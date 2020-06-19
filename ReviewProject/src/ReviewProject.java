public class ReviewProject 
{

    public static void findingTheWords(String paragraph,char StartingCharacter,char endingCharacter)
    {
        String storageArray[] = paragraph.split(" ");
        
        for(int i = 0;i < storageArray.length;i++)
        {
            System.out.println(storageArray[i]);
        }
    }
    public static void main(String[] args) 
    {
        String paragraph = "My name is vicky";
        char StartingCharacter = 'v';
        char endingCharacter = 'y';
        findingTheWords(paragraph,StartingCharacter,endingCharacter);    
    }
}