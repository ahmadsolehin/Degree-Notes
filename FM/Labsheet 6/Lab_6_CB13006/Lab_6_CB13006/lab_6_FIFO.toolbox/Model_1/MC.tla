---- MODULE MC ----
EXTENDS lab_6_FIFO, TLC

\* INIT definition @modelBehaviorNoSpec:0
init_14163603682204000 ==
FALSE/\buffer = 0
----
\* NEXT definition @modelBehaviorNoSpec:0
next_14163603682305000 ==
FALSE/\buffer' = buffer
----
=============================================================================
\* Modification History
\* Created Wed Nov 19 09:26:08 SGT 2014 by FSK 10B
