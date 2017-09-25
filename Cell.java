

public class Cell {
       
       
 
       
        private static class Square
        {
                public int [][] pix=new int[2][2];
                public Square(int i,int j, int k,int l)
                {
                        this.pix[0][0]=i;
                        this.pix[0][1]=j;
                        this.pix[1][0]=k;
                        this.pix[1][1]=l;
                }
                public int get(int i, int j) {
                       
                        return pix[i][j];
                }
        }
       
        public static final Square[] squares= new Square[]
        {
                new Square(1,1,0,0),
                new Square(0,0,1,1),
                new Square(1,0,1,0),
                new Square(0,1,0,1),
                new Square(1,0,0,1),
                new Square(0,1,1,0)
        };
       
       
        public static int xx(int r)
        {
                return squares[r].get(0,0);
        }
       
        public static int xy(int r)
        {
                return squares[r].get(0,1);
        }
        public static int yy(int r)
        {
                return squares[r].get(1,0);
        }
        public static int yx(int r)
        {
                return squares[r].get(1,1);
        }
       
        public static int inverse(int n)
        {
                switch(n)
                {
                        case 0:
                                return 1;
                        case 1:
                                return 0;
                }
                return n;
        }
       
        public static void main(String args[]) {
           xx(3);
        }
 
}