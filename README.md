# cs320testing_and_automation
How can I ensure that my code, program, or software is functional and secure?
How do I interpret user needs and incorporate them into a program?
How do I approach designing software?

In designing software, everything begins with figuring out what problem we are trying to solve, be it from pre-existing requirements or a completely new idea.  
Software that solves problems is infinitely preferable to software that does something completely unnecessary.  To this end, requirements research should take up a
considerable amount of time in the beginning.  Be it interviews, surveys, focus groups -- we want as exact a definition of what users needs as possible.  Taking these
user stories, we can zero in on what the exact corresponding software should do.  Once we have the core of "what" the software should do, we can begin to hone the "how" of functionality.  I favor keeping design minimal, only adding code that will fulfill requirements while not over-complicating structure.I prefer to use method chaining to compress tasks into as few lines as possible,  and use pass by reference 
whenever possible to  minimize memory usage.
One danger of OOP (and a major aspect critics use against it) is the possibility of breaking functionality into too many methods, too many small interlocking parts that can 
obfuscate an otherwise straightforward system.  In terms of security, I see this overcomplication as a risk factor -- a system too divided surely has at least one weak spot.   
To ensure more secure code, it is vital that the proper antipatterns be applied.  This includes input validation and sanitization, protecting against injection, clickjacking, et cetera.  By keeping code as simple as possible, and applying accepted security solutions, code can meet requirements while maintaining elegance and protection.
