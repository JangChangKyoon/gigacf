<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />

<style>
html, body, #app {
  height: 100%;
}
#app {
  min-height: 100%;
  //display: flex;
  //flex-direction: column;
}
.main-content {
  //flex: 1;
}
.footer {
  margin-top: -12px;
}
@media screen and (max-width: 768px) {
  #menu-toggle:checked + .nav-menu {
    display: block;
  }
}
</style>
<body>
<nav class="navbar" role="navigation" aria-label="main navigation">
  <div class="navbar-brand">
    <a class="navbar-item" href="/v2/home">
      <img src="https://back.3blmedia.com/sites/default/files/client_content/original_csrwire/GIGA_logo.jpg" width="112" height="28">
    </a>

    <!-- 햄버거 아이콘 -->
   <a role="button" class="navbar-burger burger" aria-label="menu" aria-expanded="true" data-target="navbarBasicExample">
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
      <span aria-hidden="true"></span>
    </a>

    
  </div>

  <div id="navbarBasicExample" class="navbar-menu">
    <div class="navbar-start">
      <a class="navbar-item" href="/v2/menu/menu_list">
        Menu
      </a>

      <a class="navbar-item" href="/v2/adminOrder/order_list">
        Order
      </a>

      <div class="navbar-item has-dropdown is-hoverable">
        <a class="navbar-link">
          More
        </a>

        <div class="navbar-dropdown">
          <a class="navbar-item" href="/v2/member/member_list">
            Member
          </a>
          <a class="navbar-item">
            Coupons
          </a>
          <a class="navbar-item">
            Contact
          </a>
          <hr class="navbar-divider">
          <a class="navbar-item">
            Report an issue
          </a>
        </div>
      </div>
    </div>

    <div class="navbar-end">
      <div class="navbar-item">
        <div class="buttons"  id="buttonsContainer">          
        </div>
      </div>
    </div>
  </div>
</nav>
</body>

<script>

//SessionCookie의 값이 있나 없나 확인
function getCookieValue(cookieName) {
    var name = cookieName + "=";
    var decodedCookie = decodeURIComponent(document.cookie);
    var cookieArray = decodedCookie.split(';');

    for (var i = 0; i < cookieArray.length; i++) {
        var cookie = cookieArray[i].trim();
        if (cookie.indexOf(name) === 0) {
            return cookie.substring(name.length, cookie.length);
        }
    }
    return "";
}


// myidentifyLoginCookie의 값이 있냐 없냐에 따라서 login버튼과 logout버튼이 상황에 따라 출력되도록함.
function createButtons() {
	var myidentifyLoginCookie= getCookieValue("identifyLoginCookie");
	console.log("Value of the 'identifyLoginCookie': " + myidentifyLoginCookie);

    var buttonsContainer = document.getElementById('buttonsContainer');
    var buttonsHTML = '';

    if (myidentifyLoginCookie) {
        buttonsHTML += '<a class="button is-primary" href="/v2/user/login/logout">Logout</a>';
    } else {
        buttonsHTML += '<a class="button is-primary" href="/v2/user/register/step1"><strong>Sign up</strong></a>';
        buttonsHTML += '<a class="button is-light" href="/v2/user/login/loginForm">Log in</a>';
    }

    buttonsContainer.innerHTML = buttonsHTML;
}

// Call the function to create buttons when the document is ready
// DOMContentLoaded : the initial HTML document has been completely loaded and parsed 
// without waiting for stylesheets, images, and subframes to finish loading.
document.addEventListener('DOMContentLoaded', createButtons);
window.addEventListener('load', createButtons);
</script>

</html>