package interfaces;

public interface IntfAccount {
    void withdraw (double value);
    void deposit (double value);
    void transfer (double value, IntfAccount destiny);
    void printExtract();
}
