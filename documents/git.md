# Getting started with git 

![XKCD1597 by Randall Munroe] (http://imgs.xkcd.com/comics/git.png)

["Git" by Randall Munroe](https://xkcd.com/1597/)

Git is a command line tool that let's you save snapshots of your code that you can share or refer to later. It's incredibly useful for collaborative coding and modifying your code without unnecessary deleting or copying.

#Installation

##Linux users

Most of you linux users should be pretty familiar with the command line. To install git just use the package manager that comes with your operating system.

Debian, Ubuntu, and Linux Mint users:

<code>sudo apt-get install git</code>


Linux Standard Base and Red Hat Enterprise users:

<code>sudo yum install git</code>


Arch Linux users:

<code>sudo pacman -S git</code>

After your package manager has installed git check to see if the most recent version has been installed. (At least Git 2.0)

<code>git --version</code>

## Mac OSX users

So Mac OSX has a handy little package manager called [homebrew](http://brew.sh/) that is not installed by default. You should definitely install it if you don't have it already! The installation and use instructions are [here] (http://brew.sh/), but all you really need for now is to paste the following into your terminal.

Installing Homebrew:

<code>/usr/bin/ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)</code>

Installing Git:

<code>brew install git</code>

After your package manager has installed git check to see if the most recent version has been installed. (At least Git 2.0)

<code>git --version</code>

## Windows users

Follow the download and use instructions [here] (https://git-for-windows.github.io/).

#Usage

##Init Git

Say you have a project that you want to save backups of and work on with other people but you are really getting tired of emailing your code to eachother. Changing namespace names, etc. Now that you have git installed there's an easier way.

<code>cd</code> into the root directory of your project (The folder that contains all of the code for your project) and initilialize your first git repo!

<code>git init</code>

If everything worked you should see a message like this:

<code>Initialized empty Git repository in /Users/admin/yourprojectname/.git/</code>

Now that you have official turned your project into a git repository let's start to build snapshots. Check to see the status of your repo (mine is called gitterbug).

<code>git status</code>

![git status figure] (https://github.com/TimothyStiles/cs284/blob/master/figures/git-status.png)



If this is a new leiningen project that you just initalized as a git repo you should see something like what is above. It tells you which copy of your code you are looking at (Master branch) and the files that you are not yet tracking changes for. You'll notic the .gitignore file in there. Ignore it for now and we'll get back to it later. To save all your code as it looks right now track everything using: 

<code>git add *</code>

just as git status suggests under the list of your untracked files.

![git status figure 2] (https://github.com/TimothyStiles/cs284/blob/master/figures/git-status-2.png)

The <code>*</code> in <code>git add *</code> can be thought of as something that represents all files in the folder (except .gitignore). What we have done here is stage our code for an initial commit. Think of a commit as a quick snapshot of the changes you have made to tracked files in your codebase. Every commit is a save point that we can revert back to later.






##Fork this Repo!



