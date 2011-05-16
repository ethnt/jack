 

public class TestJack
{
    public static void main(String[] args)
    {
        String[] parameters = new String[2];
        parameters[0] = "height=50";
        parameters[1] = "width=50";
        
        Jack jack = new Jack();
        

            jack.get("http://ethan.turkeltaub.org/storage/test.php");
            jack.post("http://ethan.turkeltaub.org/storage/test.php", parameters);
            jack.put("http://ethan.turkeltaub.org/storage/test.php", parameters);
            jack.delete("http://ethan.turkeltaub.org/storage/test.php");

    }
}
