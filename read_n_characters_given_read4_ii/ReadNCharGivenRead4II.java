/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4); 
 */

public class ReadNCharGivenRead4II extends Reader4 {
    private char[] buff4;
    private int buff4Ptr;
    private int buff4Len;
    public ReadNCharGivenRead4II() {
        this.buff4 = new char[64];
        this.buff4Ptr = 0;
        this.buff4Len = 0;
    }
    
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        if (buf == null || buf.length == 0 || n < 1) {
            return 0;
        }
        
        int ptr = 0;
        buff4Len = buff4Ptr == 0 ? read4(buff4) : buff4Len;
        while (buff4Len > 0) {
            for (; this.buff4Ptr < buff4Len && ptr < n; ptr++) {
                buf[ptr] = buff4[buff4Ptr++];
            }
            if (ptr == n) {
                return ptr;
            }
            buff4Len = read4(buff4);
            buff4Ptr = 0;
        }
        
        return ptr;
    }
}