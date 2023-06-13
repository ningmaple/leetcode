/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class ReadNCharactersGivenRead4 extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private char[] buff4;
    private int ptr;
    public Solution() {
        this.buff4 = new char[64];
        this.ptr = 0;
    }
    
    public int read(char[] buf, int n) {
        if (n < 1 || buf == null || buf.length == 0) {
            return 0;
        }
        
        int buff4Size = 0;
        while ((buff4Size = read4(buff4)) > 0 && ptr < n) {
            for (int i = 0; i < buff4Size && ptr < n; i++) {
                buf[ptr++] = buff4[i];
            }
        }
        
        return ptr;
    }
}