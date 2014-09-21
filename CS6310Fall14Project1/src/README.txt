Project: Heated Plate Experiment

Participants:
    Reece Karge 	(rkarge3)
    Alexandr Dorofeyev 	(adorofeyev3)
    Kimanii Daniel 	(kdaniel38)
    Andre Pollard 	(apollard6)
    Michael Tidwell 	(mtidwell3)

Instructions:

Compilation:

(PATH_TO_PROJECT is the path to the location on the hard drive where the project was saved)
cd PATH_TO_PROJECT/Project-1-Heated-Plate/CS6310Fall14Project1/src/

javac */*.java


Syntax: java <packageName>.Demo -d # -l # -r # -t # -b #
    Replace <packageName> with any one of Tpdohp, Tpdahp, Tpfahp or Twfahp

Parameters: (Parameters can be entered in any order but they're all required)
    -d #:   This represents the dimension of the grid.
            eg: -d 10

    -l #:   This represents the left temperature on the grid
            eg: -l 75

    -r #:   This represents the right temperature on the grid
            eg: -r 50

    -t #:   This represents the top temperature on the grid
            eg: -t 100

    -b #:   This represents the bottom temperature on the grid
            eg: -b 0

Examples:
    java Tpdahp.Demo -d 10 -l 75 -r 50 -t 100 -b 0
    java Twfahp.Demo -d 10 -l 75 -r 50 -t 100 -b 0
    java Tpfahp.Demo -d 10 -l 75 -r 50 -t 100 -b 0

Expected Results:
    [83.57][84.90][83.74][80.55][72.64]
    [74.39][72.30][69.51][65.86][60.00]
    [66.70][60.42][56.18][53.40][51.50]
    [57.02][46.54][41.43][40.10][42.62]
    [39.83][27.32][22.93][22.98][28.90]

