% Load a puzzle from a text file, and return the specification for a Java object containing it
getCourses(F) :- load_dyn(F).
getPreReq(F) :- load_dyn(F).

%allow Java to access all possible variable values
nonDeterministicGoal(VarsWanted,G,ListTM) :- findall(VarsWanted,G,L), buildTermModel(L,ListTM).











%test code
fun(X):-
red(X),
car(X).
fun(X):-
blue(X),
bike(X).
car(vw_beatle).
car(ford_escort).
bike(harley_davidson).
red(vw_beatle).
red(ford_escort).
blue(harley_davidson).

likes(X):-rob(X).
rob([beer,money,fun]).
rob([1,2,3,4,5,6]).
rob(money).
rob([1,2,3]):-rob(X).

parent(pam,bob).
parent(tom,bob).
parent(tom,liz).
parent(bob,ann).
parent(bob,pat).
parent(pat,jim).
female(pam).

female(liz).
female(pat).
female(ann).

offspring(Y, X):-parent( X, Y).

male(X):-female(X).

processList([],[]). 
processList([A|L],[string(A)|LL]):-female(A), parent(L,LL). 

parent([],[]).
parent([A|L],[string(A)|LL]):-rob(A),parent(L,LL).

