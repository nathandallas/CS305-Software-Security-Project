# CS305 Software Security Project 

## Client and Software Requirements 

Artemis Financial is a consulting company that develops individualized financial plans, including savings, retirement, investments, and insurance. They wanted to modernize their operations and add a file verification step to their public web application to ensure secure communication between the client and server, including a checksum to verify that data transferred through their systems have not been altered or intercepted.  

## Finding Vulnerabilities and Secure Coding 

I did well at matching security controls to the client's needs. For the checksum, I recommended SHA-256 because it is fast, NIST-approved, and built into Java. I ruled out MD5 and SHA-1 because of their known collision attacks. The OWASP Dependency-Check scan showed me that the project's existing Spring Boot libraries contained 14 vulnerable dependencies, which would have been missed in a manual review.  

Secure coding matters for any application, but in this case where the client is a financial institution that handles sensitive customer data and is required to protect it under regulations like the Gramm-Leach-Bliley Act, extra care should be taken to ensure compliance. Software security protects a company from breaches that lead to financial loss, regulatory penalties, and lost customer trust, and preventing those problems costs less than cleaning them up.  

## Helpful Parts 

I found the vulnerability assessment process flow chart to be extremely helpful in guiding my decisions and determining where security should be added. The dependency-check tool was also  

## Increasing Layers of Security 

Security was added in layers so that each solution covered gaps in the others. The SHA-256 checksum detects modified data, HTTPS encrypts data and the checksum in transit, the error handling prevents secrets or data from being leaked in the stack trace, and the keystore password was stored in an environment variable instead of the source code. In the future, I would start with the vulnerability assessment flow diagram and OWASP Dependency-Check, then use the scan report to decide which vulnerabilities to mitigate first. 

## Ensuring Functional and Secure Code 

I manually reviewed the refactored code for syntax, logic, and security issues, then ran the application to confirm it started without errors over HTTPS. Reloading the page and restarting the application produced the same checksum each time, and Firefox's Page Info window confirmed the connection was encrypted using my certificate. After refactoring, I ran the dependency-check scan again. My code added no new third-party libraries, so every flagged vulnerability came from the original Spring Boot libraries. 

## Resources, Tools, and Practices 

The tools I will use going forward are the OWASP Dependency-Check scan, the vulnerability assessment flowchart, and Maven in Eclipse. The coding practices I want to keep using are relying on vetted, industry-standard algorithms instead of custom cryptography, keeping secrets like passwords outside of source code, and error handling.  

## What I Would Show Employers 

I would show employers this report as an example of taking an insecure application and turning it into a tested, secure version. This project and report show that I can analyze vulnerabilities, configure HTTPS, research and recommend a cryptography solution, and document and justify my process and decisions.  
