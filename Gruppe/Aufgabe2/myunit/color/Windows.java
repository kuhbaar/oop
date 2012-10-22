package myunit.color;

import myunit.color.Win32.Kernel32;

/* adapted from http://stackoverflow.com/questions/1448858/how-to-color-system-out-println-output */
public class Windows extends API {
  public void printSuccess(String msg) {
    static_save_settings();
    static_set_color(Win32.BLACK, Win32.GREEN);
    System.out.println("  - " + name + " sucessful");
    static_restore_color();
  }

  public void printFailure(String msg) {
    static_save_settings();
    static_set_color(Win32.BLACK, Win32.RED);
    System.out.println("  - " + name + " failed: " + cause);
    static_restore_color();
  }

  private Win32.CONSOLE_SCREEN_BUFFER_INFO buffer_info = null; 

  private void static_save_settings() {
    if (null == buffer_info) buffer_info = new Win32.CONSOLE_SCREEN_BUFFER_INFO();
    int stdout_handle = Kernel32.DLL.GetStdHandle(Win32.STD_OUTPUT_HANDLE);
    Kernel32.DLL.GetConsoleScreenBufferInfo(stdout_handle, buffer_info);
  }

  private void static_restore_color() {
    int stdout_handle = Kernel32.DLL.GetStdHandle(Win32.STD_OUTPUT_HANDLE);
    Kernel32.DLL.SetConsoleTextAttribute(stdout_handle, buffer_info.wAttributes);
  }

  private void static_set_color(Short bg, Short fg) {
    int stdout_handle = Kernel32.DLL.GetStdHandle(Win32.STD_OUTPUT_HANDLE);
    short color = (short) ((bg.shortValue() << 8) | fg.shortValue());
    Kernel32.DLL.SetConsoleTextAttribute(stdout_handle, color);
  }
}