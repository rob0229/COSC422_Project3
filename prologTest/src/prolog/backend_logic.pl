% Load student and course data from a file
getCourses(F) :- load_dyn(F).
getPreReq(F) :- load_dyn(F).
getStudent(F) :- load_dyn(F).

%allow Java to access all possible variable values
nonDeterministicGoal(VarsWanted,G,ListTM) :- findall(VarsWanted,G,L), buildTermModel(L,ListTM).

%get all the courses taken  
takenList([]).
takenList([H|L]) :- taken(H), takenList(L).

%compare the courses taken with the degree requirements and return a list of classes still needed

%return a list of all the classes that a student is eligable to take next semester

%get the prereqs for a specific course
getPrereqList(X, Y).
