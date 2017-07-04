--------------------------- MODULE LiveHourClock ---------------------------

EXTENDS HourClock


LSpec==HC/\WF_hr(HCnxt)

AlwaysTick==[]<><<HCnxt>>_hr

AllTimes==\A n\in (1..10):[]<>(hr=n)

\*New == (hr = 1) => <>(hr = 2)

\*temporal == (hr = 1) =>  <> []  (hr = 2)

temporal == (hr = 1) =>  [] <> (hr = 2)

 exist == hr \in (1 .. 12)    

TypeInvariance==[]HCini

-----------------------------------------------------------------------------
THEOREM LSpec => AlwaysTick/\AllTimes/\TypeInvariance


=============================================================================
\* Modification History
\* Last modified Fri Apr 14 08:51:58 SGT 2017 by FSK 1
\* Created Fri Apr 14 08:32:29 SGT 2017 by FSK 1

\*ANSWER:

\*Q5:   The distinct state for live hour clock going to 10 step are 600 because /\ it show combination between min 
\*      and hour so that means the modul will show the value min * hr, 10*60=600

\*Q7:   This statement was error
\*      Property New is violated by the initial state:
\*      /\ min = 1
\*      /\ hr = 1
\*      this error occur because when we =>, its mean we need 2 hours immediately
\*      so we add tempral logical '<>' in this statement.

\*Q8:   This statement was error but we need to add temporal logical '<>' because it will True at the sometime.
\*Q8.2: This infinetely often statement was error.
\*Q8.3: This eventually always statement was true.

\*Q9:   exist == hr \in (1 .. 12)   
\*Q10:   new == [] (hr = 1) => (hr = 2)_hr 
\*the temporal formula is equal to 1