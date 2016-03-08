# A tutorial series about programming in clojure for CS284 Evolutionary Computation. 
Each folder contains a project or markdown explaining or reviewing a certain topic. For code tutorials cd into the given tutorial directory, run <code>lein gorilla</code>, and open in your browser for an interactive gorilla repl.

# Class Coding Resources and Materials.

Here's a general rundown on coding resources available to the class. Lee already has a pretty great list of resources on the class moodle that cover coding and Evo Comp but I am hoping that this becomes a list of resources that students add to and share with each other. If you have something you want to add here let me know or just send a pull request!

##Writing Clojure
There a few tutorials that I have written here but I have found that the book [Clojure for the Brave and True by Daniel Higginbotham](http://www.braveclojure.com/) is particularly well written and freely available online. Supplementary code can also be [found on github here] (https://github.com/braveclojure/cftbat-code/). 

Here's a list of clojure libraries that expand clojure's functionality into making music, image processing, computer vision, machine learning, numerical computing, genetic programming, and artificial life that I have some experience with. (Disclaimer: I have made minor contributions to two of the libraries listed here.) If you are new to clojure **it would be much easier to experiment with Evolutionary Computation without these libraries** but if you feel compelled to work with any of these libraries for some reason or another here they are. Also, if you use a library that you think would be useful to the class let me know and I will add it to the list!

[Clojush](https://github.com/lspector/Clojush): Lee's implementation of Push GP in Clojure. Heavily used in his research group and quite popular on github!

[Pucks](https://github.com/lspector/pucks): Lee's 2D world of Pucks! An artificial life simulator based around little puck creatures.

[Brevis](https://github.com/kephale/brevis): A 3D artificial life simulator developed by Hampshire Alumn Kyle Harrington. His blog contains a [tutorial on creating swarms](http://computational.life).

[FunImage](https://github.com/funimage/funimage): A functional image processing library also developed by Kyle that I am very familiar with.

[Overtone](https://github.com/overtone/overtone): Music generation library for clojure that I know some people in the class are already using.

[Core.matrix](https://github.com/mikera/core.matrix): Matrix library that uses native clojure data structures.

[clj-ml](https://github.com/joshuaeckroth/clj-ml): A somewhat non-idiomatic clojure library for machine learning. I would suggest that most stay away from it but someone could find it useful.

[spectre](https://github.com/nathanmarz/specter): Lee suggested map manipulating library. 



##Tooling and other resources
Git and Source Version Control: A great book for getting familiar with git and version control  is [Pro Git by Scott Chacon and Ben Straub] (http://git-scm.com/book/en/v2). The book is freely available through a creative commons license and it comes in almost every format needed (pdf, mobi, epub, web, etc). It's a little lengthy but to get started one only really has to read the first three or four chapters. Expect to see a tutorial on git here in the coming weeks.

Linux Command Line BASH: [Another great free book on linux command line BASH by William E. Shotts, Jr.] (http://linuxcommand.org/tlcl.php)

Text Editors and IDEs: emacs, vim, atom, eclipse, lightable, etc, etc, etc. Clojure programmers are fond of emacs because it was originally built for Lisp. I prefer emacs with vim bindings (evil mode) and highly suggest using emacs, the gorilla repl, or counterclockwise for this class. All of you should already have a developing environment but if you are interested in setting up emacs on your machine [chapter 2 of Clojure for the Brave and True] (http://www.braveclojure.com/basic-emacs/) does an excellent job of introducing Emacs as a clojure editor/ide.

Getting started with the cluster: Getting your code to run on the cluster takes a little bit of hard work to set up at first. If you do not have any experience with BASH I would recommend learning how to navigate on the command line before you try to run your code on Hampshire's high performance computing cluster. If you are interested in running your code on the cluster talk to Lee so that he can have your account set up and then meet with Ben or I to help walk you through getting your code to run. Here are some [instructions prepared by Andrew Zito](https://github.com/TimothyStiles/cs284/blob/master/documents/fly.pdf).

[College Level Mathematics](http://aimath.org/textbooks/approved-textbooks/): A series of college level math textbooks that are freely licensed and good for referencing. Collected and supported by the American Institute of Mathematics and the National Science Foundation. You are not expected to get really deep into the math that you may see in some readings for this class but if you are curious most of the notation you will see can be explained by one of these books.

## license
Copyright 2016 Timothy S. Stiles

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

