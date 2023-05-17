/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class ReadNCharGivenRead4II extends Reader4 {
    private int len;
    private int ptr;
    private char[] buff;
    
    public Solution() {
        this.len = 0;
        this.ptr = 0;
        this.buff = new char[64];
    }
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0) {
            return 0;
        }
        
        int counter = 0;
        while (counter < n) {
            if (this.ptr == 0 && (this.len = read4(this.buff)) == 0) {
                break;
            }
            
            while (this.ptr < this.len && counter < n) {
                buf[counter++] = this.buff[this.ptr++];
            }
            if (this.ptr == this.len) {
                this.ptr = 0;
            }
        }   
        
        return counter;
    }
}