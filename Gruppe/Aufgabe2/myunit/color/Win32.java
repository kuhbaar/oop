package myunit.color;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Platform;
import com.sun.jna.Structure;

/* adapter from http://stackoverflow.com/questions/1448858/how-to-color-system-out-println-output */
public class Win32 {
    public static final int STD_OUTPUT_HANDLE = -11;
    public static final int STD_ERROR_HANDLE = -12;

    public static final short BLACK        = 0x00;
    public static final short BLUE         = 0x01;
    public static final short GREEN        = 0x02;
    public static final short AQUA         = 0x03;
    public static final short RED          = 0x04;
    public static final short PURPLE       = 0x05;
    public static final short YELLOW       = 0x06;
    public static final short WHITE        = 0x07;
    public static final short GRAY         = 0x08;
    public static final short LIGHT_BLUE   = 0x09;
    public static final short LIGHT_GREEN  = 0x0A;
    public static final short LIGHT_AQUA   = 0x0B;
    public static final short LIGHT_RED    = 0x0C;
    public static final short LIGHT_PURPLE = 0x0D;
    public static final short LIGHT_YELLOW = 0x0E;
    public static final short BRIGHT_WHITE = 0x0F;

    public static class COORD extends Structure {
        public short X;
        public short Y;
    }

    public static class SMALL_RECT extends Structure {
        public short Left;
        public short Top;
        public short Right;
        public short Bottom;
    }

    public static class CONSOLE_SCREEN_BUFFER_INFO extends Structure {
        public COORD dwSize;
        public COORD dwCursorPosition;
        public short wAttributes;
        public SMALL_RECT srWindow;
        public COORD dwMaximumWindowSize;
    }

    // Source: https://github.com/twall/jna/nonav/javadoc/index.html
    public interface Kernel32 extends Library {
        Kernel32 DLL = (Kernel32) Native.loadLibrary("kernel32", Kernel32.class);

        public int GetStdHandle(
                int nStdHandle);

        public boolean SetConsoleTextAttribute(
                int in_hConsoleOutput, 
                short in_wAttributes);

        public boolean GetConsoleScreenBufferInfo(
                int in_hConsoleOutput,
                CONSOLE_SCREEN_BUFFER_INFO out_lpConsoleScreenBufferInfo);
    }
}