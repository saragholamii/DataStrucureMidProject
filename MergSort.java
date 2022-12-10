public class MergSort {

    public void MergSortTheList(int[][] theArray, int p, int r)
    {
        if(p < r)
        {
            int q = (p + r) / 2;
            MergSortTheList(theArray, p, q);
            MergSortTheList(theArray, q + 1, r);
            Sort(theArray, p, q, r);
        }
    }

    public void Sort(int[][] theArray, int p, int q, int r)
    {
        int theFirstArrayLength = q - p + 1;
        int theSecoundArrayLength = r - q;

        int[][] firstArray = new int[theFirstArrayLength][3];
        int[][] secoundArray = new int[theSecoundArrayLength][3];
        
        for(int i = 0; i < theFirstArrayLength; i++)
        {
            firstArray[i][0] = theArray[p + i][0];
            firstArray[i][1] = theArray[p + i][1];
            firstArray[i][2] = theArray[p + i][2];
        }

        for(int i = 0; i < theSecoundArrayLength; i++)
        {
            secoundArray[i][0] = theArray[q + 1 + i][0];
            secoundArray[i][1] = theArray[q + 1 + i][1];
            secoundArray[i][2] = theArray[q + 1 + i][2];
        }

        int i = 0, j = 0, k = p;
        while(i < theFirstArrayLength && j < theSecoundArrayLength)
        {
            if(firstArray[i][2] > secoundArray[j][2])
            {
                theArray[k][0] = firstArray[i][0];
                theArray[k][1] = firstArray[i][1];
                theArray[k][2] = firstArray[i][2];
                i++;
            }
            else
            {
                theArray[k][0] = secoundArray[j][0];
                theArray[k][1] = secoundArray[j][1];
                theArray[k][2] = secoundArray[j][2];
                j++;
            }

            k++;
        }

        while (i < theFirstArrayLength) 
        {
            theArray[k][0] = firstArray[i][0];
            theArray[k][1] = firstArray[i][1];
            theArray[k][2] = firstArray[i][2];
            i++;
            k++;
        }

        while (j < theSecoundArrayLength) 
        {
            theArray[k][0] = secoundArray[j][0];
            theArray[k][1] = secoundArray[j][1];
            theArray[k][2] = secoundArray[j][2];
            j++;
            k++;
        }
    }
}
