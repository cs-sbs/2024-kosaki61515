package com.flash.utils;

/**
 * 控制台美化工具类 - 深邃商务风格
 */
public class ConsoleUtil {
    // 前景色 - 使用深色系
    public static final String RESET = "\u001B[0m";
    public static final String BLUE = "\u001B[38;5;33m";       // 深蓝色
    public static final String GRAY = "\u001B[38;5;245m";      // 深灰色
    public static final String GREEN = "\u001B[38;5;28m";      // 深绿色
    public static final String RED = "\u001B[38;5;160m";       // 深红色
    public static final String GOLD = "\u001B[38;5;178m";      // 金色
    public static final String WHITE = "\u001B[38;5;255m";     // 亮白色
    public static final String CYAN = "\u001B[38;5;31m";       // 深青色

    // 背景色
    public static final String BG_BLUE = "\u001B[48;5;33m";
    public static final String BG_GRAY = "\u001B[48;5;245m";
    public static final String BG_GREEN = "\u001B[48;5;28m";
    public static final String BG_RED = "\u001B[48;5;160m";
    public static final String BG_GOLD = "\u001B[48;5;178m";
    public static final String BG_WHITE = "\u001B[48;5;255m";
    public static final String BG_CYAN = "\u001B[48;5;31m";

    /**
     * 打印标题
     */
    public static void printTitle(String title) {
        String line = "========================================";
        System.out.println(BLUE + line + RESET);
        System.out.println(WHITE + "【 " + title + " 】" + RESET);
        System.out.println(BLUE + line + RESET);
    }

    /**
     * 打印分隔线
     */
    public static void printDivider() {
        System.out.println(GRAY + "----------------------------------------" + RESET);
    }

    /**
     * 打印菜单选项
     */
    public static void printMenuItem(int index, String item) {
        System.out.printf(GREEN + "  %d. %s\n" + RESET, index, item);
    }

    /**
     * 打印错误信息
     */
    public static void printError(String message) {
        System.out.println(RED + "【错误】" + message + RESET);
    }

    /**
     * 打印成功信息
     */
    public static void printSuccess(String message) {
        System.out.println(GREEN + "【成功】" + message + RESET);
    }

    /**
     * 打印警告信息
     */
    public static void printWarning(String message) {
        System.out.println(GOLD + "【警告】" + message + RESET);
    }

    /**
     * 打印信息
     */
    public static void printInfo(String message) {
        System.out.println(CYAN + "【信息】" + message + RESET);
    }

    /**
     * 打印进度条
     */
    public static void printProgressBar(int progress, int total) {
        int width = 40;
        int completed = (int) ((double) progress / total * width);
        System.out.print("\r" + BLUE + "[");
        for (int i = 0; i < width; i++) {
            if (i < completed) {
                System.out.print("█");
            } else if (i == completed) {
                System.out.print("▓");
            } else {
                System.out.print("░");
            }
        }
        System.out.printf("] %d%%" + RESET, (int) ((double) progress / total * 100));
    }

    /**
     * 打印加载动画
     */
    public static void printLoadingAnimation(String message, int seconds) {
        String[] frames = {"⠋", "⠙", "⠹", "⠸", "⠼", "⠴", "⠦", "⠧", "⠇", "⠏"};
        int framesPerSecond = 10;
        int totalFrames = seconds * framesPerSecond;
        
        for (int i = 0; i < totalFrames; i++) {
            System.out.print("\r" + BLUE + message + " " + 
                           frames[i % frames.length] + RESET);
            try {
                Thread.sleep(1000 / framesPerSecond);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
        System.out.println();
    }

    /**
     * 清屏
     */
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        // 备选方案
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    /**
     * 打印带颜色的文本
     */
    public static void printColored(String text, String color) {
        System.out.print(color + text + RESET);
    }

    /**
     * 打印带颜色的一行文本
     */
    public static void printlnColored(String text, String color) {
        System.out.println(color + text + RESET);
    }
} 