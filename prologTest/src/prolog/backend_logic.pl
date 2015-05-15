
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

%get all the required courses
requiredList([]).
requiredList([H|L]) :- required(H), requiredList(L).

%compare the courses taken with the degree requirements and return a list of classes still needed

%get a list of all the classes that a student is eligible to take next semester. Just return 
%all classes that the student has the prereq for and not already taken
eligibleToTake(Class) :- prereq(Class, PrereqList), takenList(PrereqList), not taken(Class).

eligibleToTakespeven(Class) :- speven(Class), eligibleToTake(Class).
eligibleToTakefaeven(Class) :- faeven(Class), eligibleToTake(Class).
eligibleToTakespodd(Class) :- spodd(Class), eligibleToTake(Class).
eligibleToTakefaodd(Class) :- faodd(Class), eligibleToTake(Class).

%get classes still left to take

requiredToTake(X) :- degree(X), not taken(X).
electivesTaken(X) :- degreeElectives(X), taken(X).
electivesToTake(X) :- degreeElectives(X), not taken(X).

%has student taken one of the 3 research classes?
takenResearch() :- taken(cosc380); taken(cosc390); taken(cosc495).

%planTaken is classes taken + planned to take for multi-semester plan
planTakenList([]).
planTakenList([H|L]) :- planTaken(H), planTakenList(L).

member(X,[X|T]).
member(X,[H|T]) :- member(X,T).
multisem(S) :- degreeList(X), member(S, X), not taken(S).