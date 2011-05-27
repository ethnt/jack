# Jack

**Author:** [Ethan Turkeltaub](http://ethan.heroku.com)

**License:** [Creative Commons Attribution-ShareAlike 3.0 Unported](http://creativecommons.org/licenses/by-sa/3.0/)

**Description:** Ease the pain of making HTTP requests in Java.

### Quick Walkthrough

  Jack jack = new Jack("ethan", "13201"); // Leave empty for no authentication.
  jack.post("http://ethan.turkeltaub.org/jack", { "hello" }); // => POST hello

### Changelog

#### 27 May 2011
*  Basic authentication!

#### 16 May 2011
*  Now the correct file structure for a package.
*  Completed PUT and DELETE requests.

#### 11 May 2011
*  Finished POST requests (now parameters work!)

#### 10 May 2011

*  Initial commit.