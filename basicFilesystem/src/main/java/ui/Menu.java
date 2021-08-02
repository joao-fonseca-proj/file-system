package ui;

/**
 * Menu da UI.
 */
public class Menu {

    private static String HEADER = "================================================";
    private static String TITLE = " FILE SYSTEM ";
    private static String[] OPTIONS = new String[]{"1. touch $file", "2. mkdir $dir ", "3. cat $file",
            "4. ls ", "5. ls $dir", "6. cd $dir", "7. rm $file", "8. rmdir $dir", "9. copy $file $dir",
    "10. chmod read=BOOL write=BOOL execute=BOOL $object", "11. editcontent $file $contntes",
            "12. lsdetails $dir", "13 lsdetails" };

    /**
     * Devolve o header em string.
     * @return header
     */
    public static String header() {
        return String.format("%s \n %s \n", HEADER, TITLE);
    }

    /**
     * Devolve menu de ajuda.
     * @return ajuda
     */
    public static String help() {
        String s = "";
        for (int i = 0; i < OPTIONS.length; i++) {
            s = s + "\n" + OPTIONS[i];
        }
        return s;
    }
}
