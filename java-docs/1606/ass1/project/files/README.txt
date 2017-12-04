In order to send emails in one web form, the basic steps are as follows according my self-study:
1.	Using a <form> tag in HTML file;
2.	Set the value of attribute: action of <form> tag;
3.	This value will point a HTTP URL in order to receive the values of <input> tag in this <form>
4.	After receiving the values, the server side can send the emails
As a result, in order to support Email Sending feature in my web site, a server side implementation is a must. According to my survey on the Internet, there are a couple of technologies in the server side: PHP, ASP.NET, Java or others.
Secondly, the JQUERY is Java Script library which can facilitate the development during operating the HTML and CSS using Java Script. So, even I choose to use JQUERY, a server side support is a must as well in order to send emails.
Finally, I found a website name SmtpJS, their web address is: https://smtpjs.com/. According to the documents in this website, it is very easy to integrate the feature of email sending into other website.
The sample source code about sending an email is as follows which can be found in the above website.
Email.send("from@you.com",
"to@them.com",
"This is a subject",
"this is the body",
"smtp.yourisp.com",
"username",
"password");
I also check if this website’s solution is free or not. On the website, it says that “This is a free script, no usage restrictions. You can include it license free, in any project, either commercial or non commercial.”
In order to use the above Java Script function in my web site, a specific Java Script file should be included: https://smtpjs.com/v2/smtp.js. I think it makes sense because the function Email.send needs a couple of other supports.



