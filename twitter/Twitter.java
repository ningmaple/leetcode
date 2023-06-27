class Twitter {
    private static class Tweet {
        private int timestamp;
        private int tweetId;
        public Tweet(int timestamp, int tweetId) {
            this.timestamp = timestamp;
            this.tweetId = tweetId;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Tweet)) {
                return false;
            }

            Tweet another = (Tweet)obj;
            return this.tweetId == another.tweetId;
        }
        @Override
        public int hashCode() {
            return this.tweetId * 101;
        }
    }

    private final Map<Integer, Set<Integer>> relationships;
    private final Map<Integer, TreeSet<Tweet>> usersNews;
    private final Map<Integer, TreeSet<Tweet>> usersPosts;
    private int time;

    public Twitter() {
        this.relationships = new HashMap<>();
        this.usersNews = new HashMap<>();
        this.usersPosts = new HashMap<>();
        this.time = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        if (!this.usersPosts.containsKey(userId)) {
            this.usersPosts.put(userId, new TreeSet<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    if (t1.timestamp == t2.timestamp) {
                        return 0;
                    }
                    return t1.timestamp > t2.timestamp ? -1 : 1;
                }
            }));
        }
        if (!this.usersNews.containsKey(userId)) {
            this.usersNews.put(userId, new TreeSet<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    if (t1.timestamp == t2.timestamp) {
                        return 0;
                    }
                    return t1.timestamp > t2.timestamp ? -1 : 1;
                }
            }));
        }

        Tweet tweet = new Tweet(++this.time, tweetId);
        this.usersPosts.get(userId).add(tweet);
        this.usersNews.get(userId).add(tweet);
        
        if (!relationships.containsKey(userId)) {
            return;
        }
        Set<Integer> neighbors = relationships.get(userId);
        for (int nei : neighbors) {
            if (!usersNews.containsKey(nei)) {
                usersNews.put(nei, new TreeSet<>(new Comparator<Tweet>() {
                    @Override
                    public int compare(Tweet t1, Tweet t2) {
                        if (t1.timestamp == t2.timestamp) {
                            return 0;
                        }
                        return t1.timestamp > t2.timestamp ? -1 : 1;
                    }
                }));
            }
            usersNews.get(nei).add(tweet);
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        if (!this.usersNews.containsKey(userId)) {
            return new ArrayList<Integer>();
        }

        List<Integer> news = new ArrayList<>();
        TreeSet<Tweet> tweets = this.usersNews.get(userId);
        for (Tweet tweet : tweets) {
            news.add(tweet.tweetId);
            if (news.size() == 10) {
                break;
            }
        }

        return news;
    }
    
    public void follow(int followerId, int followeeId) {
        if (!this.relationships.containsKey(followeeId)) {
            this.relationships.put(followeeId, new HashSet<>());
        }
        this.relationships.get(followeeId).add(followerId);
        
        if (!this.usersPosts.containsKey(followeeId)) {
            return;
        }
        TreeSet<Tweet> tweets = this.usersPosts.get(followeeId);
        if (!this.usersNews.containsKey(followerId)) {
            this.usersNews.put(followerId, new TreeSet<>(new Comparator<Tweet>() {
                @Override
                public int compare(Tweet t1, Tweet t2) {
                    if (t1.timestamp == t2.timestamp) {
                        return 0;
                    }
                    return t1.timestamp > t2.timestamp ? -1 : 1;
                }
            }));
        }
        for (Tweet tweet : tweets) {
            this.usersNews.get(followerId).add(tweet);
        }
    }
    
    public void unfollow(int followerId, int followeeId) {
        if (!this.relationships.containsKey(followeeId) || !this.relationships.get(followeeId).contains(followerId)) {
            return;
        }
        this.relationships.get(followeeId).remove(followerId);
        if (!usersNews.containsKey(followerId)) {
            return;
        }

        TreeSet<Tweet> tweets = this.usersPosts.get(followeeId);
        for (Tweet tweet : tweets) {
            if (!this.usersNews.get(followerId).contains(tweet)) {
                continue;
            }
            this.usersNews.get(followerId).remove(tweet);
        }
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */