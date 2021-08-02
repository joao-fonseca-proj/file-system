# file-system
Little app I developed for replicating a simple file system. Meant for my first job application ever. :)

*Finished on 10/01/2020*

## Description

* JAVA command line application used interactively through commands;
* Inspired by UNIX, has a console UI allowing the user to navigate inside a filesystem, selecting files, directories, etc;
* Developed with Domain Driven Design;
* Uses In Memory persistence, but can easily be transformed for real databases;
* Maven Project

## Commands

Every command is dependent on files permission.

* **ls**
    * **ls $dirName**
* **lsdetails**
    * **lsdetails $dirName**
* **touch $fileName**
* **mkdir $dirName**
* **rm $fileName**
* **rmdir $dirName**
* **cd ..** - Previous
  * **cd $dirName**
* **copy $fileName $dirName**
* **move $fileName $dirName**
* **chmod read=$bool write=$bool exec=$bool $file"**
* **editcontent $fileName $contents**
* **cat $fileName**
