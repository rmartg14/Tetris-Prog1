package es.unileon.prg1.tetris;

public class ArrayNxN extends ArrayMxN{

    public ArrayNxN(int size) {
        super(size,size);
    }

    public ArrayNxN(ArrayMxN initial) {
        this(Math.max(initial.rows(), initial.columns()));
        for(int i=0;i<initial.rows();i++){
            for(int j=0;j<initial.columns();j++){
                set(i,j,initial.get(i,j));
            }
        }
        
            
        


      
      // complete the rest of the code
    }

    private int length() {
       
        return array.length;
    }

    private boolean isEmptyRow(int m) {
        boolean isEmpty;
        if(m>this.length()){
            isEmpty=true;
        }else{
            isEmpty=false;
        }
        return isEmpty;
    }

    private boolean isEmptyColumn(int n) {
        boolean isEmpty=false;
        if(n>array[0].length){
            isEmpty=true;
        }
        return isEmpty;
    }

    private int getEmptyColumnsLeft() {
        int n=this.length();
        int i=0;
        int j=0;
        int colV=0;
        boolean encontrado=false;
        while(j<n&&!encontrado){
            while(i<n){
                if(get(i,j)!=0){
                    encontrado=true;
                }
                i++;
            }
            if(!encontrado){
                colV++;
            }
            i=0;
            j++;
        }

        return colV;
    }

    private int getEmptyColumnsRight() {
        int n=this.length();
        int i=n-1;
        int j=n-1;
        int colV=0;
        boolean encontrado=false;
        while(j>=0&&!encontrado){
            while(i>=0){
                if(get(i,j)!=0){
                    encontrado=true;
                }
                i--;
            }
            if(!encontrado){
                colV++;
            }
            i=n-1;
            j--;
        }

        return colV;
        
    }

    private int getEmptyRowsDown() {
        int n=this.length();
        int i=n-1;
        int j=n-1;
        int rowV=0;
        boolean encontrado=false;
        while(i>=0&&!encontrado){
            while(j>=0){
                if(get(i,j)!=0){
                    encontrado=true;
                }
                j--;
            }
            if(!encontrado){
                rowV++;
            }
            j=n-1;
            i--;
        }

        return rowV;
    }

    private int getEmptyRowsUp() {
        int n=this.length();
        int i=0;
        int j=0;
        int rowV=0;
        boolean encontrado=false;
        while(i<n&&!encontrado){
            while(j<n){
                if(get(i,j)!=0){
                    encontrado=true;
                }
                j++;
            }
            if(!encontrado){
                rowV++;
            }
            j=0;
            i++;
        }

        return rowV;
    }

    public ArrayMxN getMinArray() {
        ArrayMxN result;
        int n=this.length();
        if(n>2){
            int row=n-getEmptyRowsDown()-getEmptyRowsUp();
            int col=n-getEmptyColumnsLeft()-getEmptyColumnsRight();
            ArrayMxN sol=new ArrayMxN(row,col);
            int i=0+getEmptyRowsUp();
            int j=0+getEmptyColumnsLeft();
            int k=n-getEmptyRowsDown();
            int l=n-getEmptyColumnsRight();
            int m=0;
            int p =0;
            while(i<k){
                while(j<l){
                    sol.set(m,p,this.get(i,j));
                    j++;
                    p++;
                }
                m++;
                i++;
                j=0+getEmptyColumnsLeft();
                p=0;

            }
            result=sol;
        }else{
            result=null;
        }
        return result;
        
       
    }

    public int get(int row, int column) {
        int introducido;
        introducido=Integer.MIN_VALUE;
        if(row<this.rows()&&row>=0){
            if(column<this.columns()&&column>=0){
                introducido=array[row][column];
            }
        }
        return introducido;
    }
    

    public boolean set(int row, int column, int value) {
        boolean introducido=false;
        if(row<this.rows()&&row>=0){
            if(column<this.columns()&&column>=0){
                array[row][column]=value;
                introducido=true;
            }
        }

        return introducido;
        
    }

    public ArrayNxN getIdentity() {
        int n=this.length();
        ArrayNxN identity=new ArrayNxN(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i==j){
                    identity.set(i,j,1);
                }else{
                    identity.set(i,j,0);
                }
            }
        }
        return identity;
    }

    public ArrayNxN mirrorV() {
        int n=this.length();
        int k=n-1;
        ArrayNxN mirror=new ArrayNxN(n);
        for(int j=0;j<n;j++){
            for(int i=0;i<n;i++){
                mirror.set(i,j,get(i,k));
            }
            k--;
        }
        
        return mirror;
    }

    public ArrayNxN mirrorH() {
        int n=this.length();
        int k=n-1;
        ArrayNxN mirror=new ArrayNxN(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                mirror.set(i,j,get(k,j));
            }
            k--;
        }
        
        return mirror;
    }

    public ArrayNxN transpose() {
        int n= this.length();
        ArrayNxN transpose= new ArrayNxN(n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                transpose.set(i,j,get(j,i));
            }
        }

        return transpose;
    }

    public ArrayNxN multiply(ArrayNxN another) {
        ArrayNxN result;
        if(array[0].length==another.length()){
            int n= this.length();
            int sum=0;
            ArrayNxN mult= new ArrayNxN(n);
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    for(int k=0;k<n;k++){
                        sum+=this.get(i,k)*another.get(k,j);

                    }
                    mult.set(i,j,sum);
                    sum=0;
                }
            }
            result=mult;
        }else{
            result=null;
        }
        return result;
    }

    public ArrayNxN spinRight() {
        ArrayNxN spinnedArray;
        spinnedArray = this.transpose().multiply(this.getIdentity().mirrorV());
        return spinnedArray;
    }

    public ArrayNxN spinLeft() {
        ArrayNxN spinnedArray;
        spinnedArray = this.transpose().multiply(this.getIdentity()).mirrorH();
        return spinnedArray;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        for(int i=0;i<this.rows();i++){
            for(int j=0;j<this.columns();j++){
                buffer.append(array[i][j]);
            }
                buffer.append("\n");
        }
        return buffer.toString();
    }
}