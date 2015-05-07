% Load student and course data from a file
getCourses(F) :- load_dyn(F).
getPrereq(F) :- load_dyn(F).
getStudent(F) :- load_dyn(F).
getDegreeRequirements(F) :- load_dyn(F).

%allow Java to access all possible variable values
nonDeterministicGoal(VarsWanted,G,ListTM) :- findall(VarsWanted,G,L), buildTermModel(L,ListTM).

%get all the courses taken  
takenList([]).
takenList([H|L]) :- taken(H), takenList(L).

%compare the courses taken with the degree requirements and return a list of classes still needed


%get a list of all the classes that a student is eligable to take next semester. Just return 
%all classes that the studen has the prereq for and not already taken
eligibleToTake(Class) :- prereq(Class, PrereqList), takenList(PrereqList), not taken(Class).

eligibleToTakespeven(Class) :- speven(Class), eligibleToTake(Class).
eligibleToTakefaeven(Class) :- faeven(Class), eligibleToTake(Class).
eligibleToTakespodd(Class) :- spodd(Class), eligibleToTake(Class).
eligibleToTakefaodd(Class) :- faodd(Class), eligibleToTake(Class).

requiredToTake(X) :- degree(X), not taken(X).
electivesTaken(X) :- degreeElectives(X), taken(X).
electivesToTake(X) :- degreeElectives(X), not taken(X).

takenResearch() :- taken(cosc380); taken(cosc390); taken(cosc495).
