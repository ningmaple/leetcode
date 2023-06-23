class RandomizedSet {
private:
    unordered_map<int, int>* val_to_idx;
    int* array;
    int size;
    int cap;
    double FACTOR = 0.75;
    
public:
    RandomizedSet() {
        this->val_to_idx = new unordered_map<int, int>();
        this->cap = 16;
        this->array = new int[cap];
        this->size = 0;
    }
    
    bool insert(int val) {
        if ((*this->val_to_idx).find(val) != (*this->val_to_idx).end()) {
            return false;
        }
        
        (*this->val_to_idx)[val] = size;
        this->array[size++] = val;
        if (this->FACTOR * this->cap <= this->size) {
            resize();
        }
        
        return true;
    }
    
    bool remove(int val) {
        if ((*this->val_to_idx).find(val) == (*this->val_to_idx).end()) {
            return false;
        }
        if (this->size == 1) {
            this->size = 0;
            (*this->val_to_idx).erase(val);
            return true;
        }

        (*this->val_to_idx)[this->array[size - 1]] = (*this->val_to_idx)[val];
        this->array[(*this->val_to_idx)[val]] = this->array[(size--) - 1];
        (*this->val_to_idx).erase(val);
        return true;
    }
    
    int getRandom() {
        return this->array[rand() % size];
    }

private: 
    void resize() {
        this->cap *= 2;
        int* new_array = new int[this->cap];
        for (int i = 0; i < this->size; i++) {
            new_array[i] = this->array[i];
        }
        delete[] this->array;
        this->array = new_array;
    }
};

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet* obj = new RandomizedSet();
 * bool param_1 = obj->insert(val);
 * bool param_2 = obj->remove(val);
 * int param_3 = obj->getRandom();
 */