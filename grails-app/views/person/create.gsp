
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Create Person</title>
        <script language="javascript">
 
function addAddr(tblId)
{
  var tblBody = document.getElementById(tblId).tBodies[0];
  var newNode = tblBody.rows[0].cloneNode(true);
  var count = parseInt(document.getElementById("addrCount").value);
  count++;
  document.getElementById("addrCount").value = count;
  var cells = newNode.cells;
  for (var i=0; i<cells.length; i++) {
      if (cells[i].firstElementChild.id.indexOf("street") != -1) {
          cells[i].firstElementChild.id = "addresses["+(count-1)+"].street";
          cells[i].firstElementChild.name = "addresses["+(count-1)+"].street";
      } else if (cells[i].firstElementChild.id.indexOf("city") != -1) {
          cells[i].firstElementChild.id = "addresses["+(count-1)+"].city";
          cells[i].firstElementChild.name = "addresses["+(count-1)+"].city";
      } else if (cells[i].firstElementChild.id.indexOf("state") != -1) {
          cells[i].firstElementChild.id = "addresses["+(count-1)+"].state";
          cells[i].firstElementChild.name = "addresses["+(count-1)+"].state";
      }  else if (cells[i].firstElementChild.id.indexOf("zip") != -1) {
          cells[i].firstElementChild.id = "addresses["+(count-1)+"].zip";
          cells[i].firstElementChild.name = "addresses["+(count-1)+"].zip";
      }
  }
  tblBody.appendChild(newNode);
}
</script>
                 
    </head>
    <body>
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Person List</g:link></span>
        </div>
        <div class="body">
            <h1>Create Person</h1>
            <g:if test="${flash.message}">
            <div class="message">${flash.message}</div>
            </g:if>
            <g:hasErrors bean="${personInstance}">
            <div class="errors">
                <g:renderErrors bean="${personInstance}" as="list" />
            </div>
            </g:hasErrors>
            <g:form action="save" method="post" >
                <g:hiddenField name="addrCount"   value="1" />
                <div class="dialog">
                    <table>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="firstName">First Name:*</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:personInstance,field:'firstName','errors')}">
                                    <input type="text" id="firstName" name="firstName" value="${fieldValue(bean:personInstance,field:'firstName')}"/>
                                </td>
                                <td valign="top" class="name">
                                    <label for="lastName">Last Name:*</label>
                                </td>
                                <td valign="top" class="value ${hasErrors(bean:personInstance,field:'lastName','errors')}">
                                    <input type="text" id="lastName" name="lastName" value="${fieldValue(bean:personInstance,field:'lastName')}"/>
                                </td>
                            </tr> 
                        </tbody>
                    </table>
                </div>
                <br/>
                <div class="dialog">
                    <table id="addrtable">
                        <thead>
                            <tr><strong>Addresses</strong></tr>
                            <tr>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" onClick="addAddr('addrtable');" value="Add Address"/></tr>
                        </thead>
                        <tbody>
                            <tr class="prop">
                                <td valign="top" class="name">
                                    <label for="street">Street:*</label>
                                </td>
                                <td valign="top" class="value">
                                    <input type="text" id="addresses[0].street" name="addresses[0].street"/>
                                </td>
                                <td valign="top" class="name">
                                    <label for="city">City:*</label>
                                </td>
                                <td valign="top" class="value">
                                    <input type="text" id="addresses[0].city" name="addresses[0].city"/>
                                </td>
                                <td valign="top" class="name">
                                    <label for="city">State:*</label>
                                </td>
                                <td valign="top" class="value">
                                    <input type="text" id="addresses[0].state" name="addresses[0].state"/>
                                </td>
                                <td valign="top" class="name">
                                    <label for="zip">Zip:*</label>
                                </td>
                                <td valign="top" class="value">
                                    <input type="text" id="addresses[0].zip" name="addresses[0].zip"/>
                                </td>
                            </tr> 
                        </tbody>
                    </table>
                </div>
                <div class="buttons">
                    <span class="button"><input class="save" type="submit" value="Create" /></span>
                </div>
            </g:form>
        </div>
    </body>
</html>
