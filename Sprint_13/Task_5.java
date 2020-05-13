 public static String readFile(String filename) {
        File file = new File(filename);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        String st = "";
        try {
            while((st = br.readLine()) != null){
                line+=st+"\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
