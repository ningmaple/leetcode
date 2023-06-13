/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char *buf4);
 */

class Read_N_Characters_Given_Read4_II {
private:
    char* buff4;
    int buff4_ptr;
    int buff4_size;
    
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    Read_N_Characters_Given_Read4_II() {
        this->buff4_ptr = 0;
        this->buff4_size = 0;
        this->buff4 = new char[64];
    }
    ~Read_N_Characters_Given_Read4_II() {
        delete[] buff4;
    }
    
    int read(char *buf, int n) {
        if (buf == NULL || n < 1) {
            return 0;
        }
        
        int buf_ptr = 0;
        buff4_size = buff4_size == 0 ? read4(buff4) : buff4_size;
        while (buff4_size) {
            for (; buff4_ptr < buff4_size && buf_ptr < n; buf_ptr++) {
                buf[buf_ptr] = buff4[buff4_ptr++];
            }
            if (buf_ptr == n) {
                return buf_ptr;
            }
            buff4_ptr = 0;
            buff4_size = read4(buff4);
        }
        
        return buf_ptr;
    }
};