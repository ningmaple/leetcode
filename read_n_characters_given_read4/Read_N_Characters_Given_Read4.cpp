/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char *buf4);
 */

class Read_N_Characters_Given_Read4 {
private:
    char* buff4;
    
public:
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    Read_N_Characters_Given_Read4() {
        this->buff4 = new char[64];
    }
    ~Read_N_Characters_Given_Read4() {
        delete[] this->buff4;
    }
    
    int read(char *buf, int n) {
        if (buf == NULL || n < 1) {
            return 0;
        }
        
        int ptr = 0;
        int recv_size = 0;
        while ((recv_size = read4(buff4))) {
            for (int i = 0; i < recv_size && ptr < n; i++) {
                buf[ptr++] = buff4[i];
            }
        }
        
        return ptr;
    }
};