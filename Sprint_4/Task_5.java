class Point {
    private int x;
    private int y;
    
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int[] getXYPair() {
        int[] xyPair = new int[2];
        xyPair[0] = x;
        xyPair[1] = y;
        return xyPair;
    }
    
    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(2,(x-this.x)) + Math.pow(2,(y-this.y)));
    }
    
    public double distance(Point point) {
         return Math.sqrt(Math.pow(2,(point.getX()-this.x)) + Math.pow(2,(point.getY()-this.y)));
    }
    
    public double distance() {
         return Math.sqrt(Math.pow(2,this.x) + Math.pow(2,this.y)); 
    }
}
