% Load student and course data from a file
getCourses(F) :- load_dyn(F).
getPreReq(F) :- load_dyn(F).
getStudent(F) :- load_dyn(F).

%allow Java to access all possible variable values
nonDeterministicGoal(VarsWanted,G,ListTM) :- findall(VarsWanted,G,L), buildTermModel(L,ListTM).

takenList([]).
takenList([H|L]) :- taken(H), takenList(L).
