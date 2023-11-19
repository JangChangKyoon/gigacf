<%@page import="com.example.gigacf.v2.menu.MenuVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html;
charset=UTF-8" pageEncoding="UTF-8"%>
<%
List<MenuVo> orderList = (List<MenuVo>) request.getAttribute("orderList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>Select Your Menu!</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bulma@0.9.4/css/bulma.min.css" />
<link rel="stylesheet" href="/css/selectmenu.css" />
</head>

<style>
.displayRows {
	display: block;
}

.displayRows.displayNone {
	display: none;
}

.displayNoneButton {
	display: none;
}
</style>

<body>
	<div class="order_body">
		<button style="border: none;" onclick="allRows()" class="order_div order_logo">
			<span>GIGA COFFEE</span>
		</button>
		<div class="order_div order_title">Modern Art Coffee</div>

		<button style="border: none;" onclick="filterPage('cf')" class="order_div order_nav-btn">
			<div class="order_nav-btn_name">COFFEE</div>
			<div class="order_nav-btn_dec">아메리카노, 카페라떼, 카푸치노</div>
		</button>
		<button style="border: none;" onclick="filterPage('non')" class="order_div order_nav-btn">
			<div class="order_nav-btn_name">NON COFFEE</div>
			<div class="order_nav-btn_dec">초코라떼, 그린티</div>
		</button>
		<button style="border: none;" onclick="filterPage('ade')" class="order_div order_nav-btn">
			<div class="order_nav-btn_name">ADE</div>
			<div class="order_nav-btn_dec">파인애플, 오랜지</div>
		</button>

		<div class="order_div order_banner">
			<span class="order_banner_span">상품을 선택한 후 1분 안에 주문해야 합니다!</span>
		</div>
		<div class="order_div order_post-big">
			<div class="order_post-big_title">기가커피 모던시티 현대인</div>
			<div>모던시티의 현대인을 위한 깊은 향으로 보답하겠습니다. 기가커피와 다름을 느껴보시기 바랍니다.</div>
		</div>


		<div class="order_div order_featured">
			<div class="order_featured_div" style="padding: 5px; display: flex;">
				<input
					style="width: 100%; font-family: Playfair Display, sans-serif; color: #888888; font-size: 40px;"
					id="submitButton" type="submit" onclick="submitForm()" value="주문하기"
				/>
				<div style="margin-left: 2em; display: none;" id="sumPrice"></div>
			</div>

		</div>

		<form class="order_form" id="myForm" name="formTable" action="" method="POST">
			<%
			for (MenuVo menu : orderList) {
			%>
			<%
			if ("커피".equals(menu.getKind())) {
			%>
			<div id="<%=menu.getNo()%>" class="order_div order_post displayRows cf "
				onclick="selectMenuNumber()"
			>
				<div style="display: flex; flex-direction: row; justify-content: space-between; height: 100%;">
					<div style="display: flex; flex-direction: column; justify-content: space-evenly;">
						<div style="font-size: 25px;"><%=menu.getCoffee()%></div>
						<div style="font-size: 20px; font-weight: bold; color: orange;" class="value-display"></div>
						<input style="display: none;" type="checkbox" name="coffee" value="<%=menu.getNo()%>" />
						<input style="display: none;" type="checkbox" name="number" /> <input style="display: none;"
							type="checkbox" name="price" value="<%=menu.getPrice()%>"
						/>
					</div>
					<div id="priceTag"><%=menu.getPrice()%>원</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			if ("논커피".equals(menu.getKind())) {
			%>
	<div id="<%=menu.getNo()%>" class="order_div order_post displayRows non "
				onclick="selectMenuNumber()"
			>
				<div style="display: flex; flex-direction: row; justify-content: space-between; height: 100%;">
					<div style="display: flex; flex-direction: column; justify-content: space-evenly;">
						<div style="font-size: 25px;"><%=menu.getCoffee()%></div>
						<div style="font-size: 20px; font-weight: bold; color: orange;" class="value-display"></div>
						<input style="display: none;" type="checkbox" name="coffee" value="<%=menu.getNo()%>" />
						<input style="display: none;" type="checkbox" name="number" /> <input style="display: none;"
							type="checkbox" name="price" value="<%=menu.getPrice()%>"
						/>
					</div>
					<div id="priceTag"><%=menu.getPrice()%>원</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			if ("에이드".equals(menu.getKind())) {
			%>
		<div id="<%=menu.getNo()%>" class="order_div order_post displayRows ade "
				onclick="selectMenuNumber()"
			>
				<div style="display: flex; flex-direction: row; justify-content: space-between; height: 100%;">
					<div style="display: flex; flex-direction: column; justify-content: space-evenly;">
						<div style="font-size: 25px;"><%=menu.getCoffee()%></div>
						<div style="font-size: 20px; font-weight: bold; color: orange;" class="value-display"></div>
						<input style="display: none;" type="checkbox" name="coffee" value="<%=menu.getNo()%>" />
						<input style="display: none;" type="checkbox" name="number" /> <input style="display: none;"
							type="checkbox" name="price" value="<%=menu.getPrice()%>"
						/>
					</div>
					<div id="priceTag"><%=menu.getPrice()%>원</div>
				</div>
			</div>
			<%
			}
			%>
			<%
			}
			%>

		</form>
	</div>



</body>

<script>
      
let timeout;


/* excute order
 * 1. selectMenuNumber()(1)
 * 2. submitForm : submitButton  import handleFormSubmission(2)
 * 4. handleFormSubmission       import sendOrderData(3)
 * 3. sendOrderData              import handleCheckboxInactivity(4)
 * 5. handleCheckboxInactivity
 
 * call order
 * 1. selectMenuNumber()
 * 4. handleFormSubmission : formdata refination // from 2. submitForm            // include 3. sendOrderData
 * 3. sendOrderData : fetch data                 // from 4. handleFormSubmission  // include 5. handleCheckboxInactivity(1 * 60 * 1000, false)
 * 5. handleCheckboxInactivity : set time 
 * 2. submitForm : submitButton                                                   // include 4. handleFormSubmission()
 */


      
      
        // 커피/논커피/에이트 버튼 누를 때 필터링 함수 
        function filterPage(rowId) { // onclick
          const rows = document.querySelectorAll(".displayRows");
          rows.forEach((row) => {
            row.classList.add("displayNone");
          });
          const selectedRows = document.querySelectorAll(`.${"${rowId}"}`);
          for (let i = 0; i < selectedRows.length; i++) {
            selectedRows[i].classList.remove("displayNone");
          }
        }

        // 로고 버튼 누를시 모든 메뉴 보이기
        function allRows() { // onclick
          const rows = document.querySelectorAll(".displayRows");
          rows.forEach((row) => {
            row.classList.remove("displayNone");
          });
        }

        // 음료 선택 및 수량과 가격 선택
        function selectMenuNumber() { // onclick
        	console.log("▶ 1. selectMenuNumber()");
          // 체크박스 선택자들 설정
          const clickedElement = event.currentTarget; // 현재 클릭한 엘리먼트
          const coffeeCheck = clickedElement.querySelector(
            'input[name="coffee"]'
          ); // coffee선택
          const numberCheck = clickedElement.querySelector(
            'input[name="number"]'
          ); // number선택
          const numberPrice = clickedElement.querySelector(
            'input[name="price"]'
          ); // price선택
          const inputValue = prompt(
            "값을 입력하세요:\n(취소버튼을 누르면 기존 주문내역이 취소됩니다.)"
          ); // 알림창에 변수 입력

          // 체크효과 설정
          if (inputValue !== null && inputValue !== "") {
            // 👁️ 사용자가 취소 버튼을 누르지 않은 경우
            const numericValue = parseInt(inputValue); // Convert input to an integer
            if (
              Number.isInteger(numericValue) &&
              numericValue >= 1 &&
              numericValue <= 9
            ) {
              coffeeCheck.checked = true;
              numberCheck.checked = true;
              numberPrice.checked = true;
              document.getElementById("submitButton").style.color="orange"
           // Trigger the "change" event for setTime to listen event
              coffeeCheck.dispatchEvent(new Event("change"));
              numberCheck.dispatchEvent(new Event("change"));
              numberPrice.dispatchEvent(new Event("change"));
              
              const showValue = clickedElement.querySelector(".value-display");
              showValue.textContent = "주문수량 : " + numericValue; // Show alerted value in page
              numberCheck.value = numericValue;
            } else {
              alert("오직 1~9 사이의 숫자만 입력 가능합니다.");
            }
          } else {
            // 사용자가 취소 버튼을 누른 경우
            numberCheck.value = "";
            const showValue = clickedElement.querySelector(".value-display");
            showValue.textContent = "";

            // 체크박스 체크 해제 (선택 사항)
            if (coffeeCheck.checked) {
              coffeeCheck.checked = false;
            }
            if (numberCheck.checked) {
              numberCheck.checked = false;
            }
            if (numberPrice.checked) {
              numberPrice.checked = false;
            }
            alert("해당 상품의 주문을 취소합니다");
          }
         
        }
        
        
      
        // ▶ 2. submitForm : submitButton
        function submitForm() { // onclick
        	 handleFormSubmission() // 이게 필요함... priceSum 땜시 미리 계산하도록 해줘야함.
        	 	console.log("▶ 2. submitForm : submitButton")
        	  const form = document.getElementById("myForm");
        	 	console.log("In submitForm : form")
      /*   	  const submitEvent = new Event("submit", { bubbles: true, cancelable: true }); 
        	 	console.log("In submitForm : submitEvent");
        	  const submitted = form.dispatchEvent(submitEvent); // 여기서 eventListen 한 데로 코드 순서가 옮겨짐 */

 /*        	  if (!submitEventTimes != 1) {
        		  submitEventTimes += 1;
        		 
        		    console.log("In submitForm: form");
        		    const submitEvent = new Event("submit", { bubbles: true, cancelable: true });
        		    console.log("In submitForm: submitEvent");
        		    
        		    form.setAttribute("data-submitted", "true");

        		    const submitted = form.dispatchEvent(submitEvent);
        		    
        		    if (submitted) {
        		    	 form.submit();
        		      }

        	  } */
 
                

                
        	  
        	  form.addEventListener("submit", function (event) {
        		  // Prevent the default form submission behavior
        		  event.preventDefault();
        		  

        		  form.submit();
        		  handleFormSubmission()
        		  
        		  document.getElementById("submitButton").style.color="black"
        	  })
        	  
        	  
        	  // 위 코드로도 eventListener가 반응하므로 아래 코드는 실질적으로 필요없음.
        	  /*   console.log("In submitForm : submitted");
        		  console.log("In submitForm : form.submit"+submitted);
        	  if (submitted) {
        		  
        	    form.submit(); // This will submit the form if the event wasn't canceled.
        	    console.log("In submitForm : form.submit();");
        	  } */
        		  
        		 
        	 
        }
        
        
        
        
        //----------------------------------------------------------------------------
        
        
        

        async function sendOrderData(order_list) {
        	console.log("▶ 3. sendOrderData : fetch data");
        	

               if (order_list.length == 0) {
            	  
               	checkboxInactivityActive = false;
               	console.log("In sendOrderData checkboxInactivityActive : "+checkboxInactivityActive);
               	handleCheckboxInactivity(1 * 60 * 1000, false);// 10 minutes in milliseconds}
             
    				alert("상품을 선택하세요");
               return;
               	} else {
              
                       // Call the function to handle form submission
               		checkboxInactivityActive = true;
               		console.log("In sendOrderData checkboxInactivityActive : "+checkboxInactivityActive);
                	 
               		handleCheckboxInactivity(1 * 60 * 1000, true);// 10 minutes in milliseconds}
               		}
        	
         
          try {
            const response = await fetch(
              "http://localhost:8081/v2/customerOrder/order_menu",
              {
                method: "POST",
                headers: {
                  "Content-Type": "application/json", // JSON 데이터를 전송한다고 명시
                },
                body: JSON.stringify(order_list), // order_list 배열을 JSON 문자열로 변환하여 요청 바디에 추가
                redirect: "follow",
              }
            );

            let data;
            if (response.ok) {
              try {
                data = await response.json();
                // JSON 데이터를 사용하는 로직
              } catch (error) {
                console.error("In sendOrderData JSON 파싱 오류:", error);
                // 오류 처리 로직 추가
              }
              console.log("In sendOrderData 서버 응답 response.ok:" +response.ok);
              return data; // 성공한 경우 데이터 반환
            } else {
              throw new Error("In sendOrderData 서버 응답 오류:" + response.status);
            }
          } catch (error) {
            throw error; // 오류 발생한 경우 예외 던지기
          }
        }
        

        
        
        
        
     // Define a function to handle form submission
        async function handleFormSubmission() {
        	console.log("▶ 4. handleFormSubmission : formdata refination");
          const form = document.getElementById("myForm");

          // Prevent the default form submission behavior
      /*     form.addEventListener("submit", async function (e) {
            e.preventDefault(); */
            console.log("In handleFormSubmission : just before submit listen");
            const formData = new FormData(form);

            // 객체 리스트 만들기 for fetching data to server
            const order_list = Array.from(formData.entries()).reduce((acc, [key, value], index) => {
              const objIndex = Math.floor(index / 3);
              if (!acc[objIndex]) {
                acc[objIndex] = {};
              }
              const obj = acc[objIndex];
              obj[key] = value;
              return acc;
            }, []);
            
            
            // 아래 함수의 알림창에 가격합게를 보여주기 위해서 html value에 값을 보내기
			let sumPriceList = [];
            order_list.forEach(list=>{
            	sumPriceList.push(parseInt(list.number)*parseInt(list.price));
            })
            let sumPrice = 0;
            sumPriceList.forEach(list=>{
            	sumPrice += list
            })
            sumPrice.toString();
            document.getElementById("sumPrice").value=sumPrice;
			
            const priceSum = document.getElementById("sumPrice").value;
      	  console.log("In submitForm : priceSum"+ priceSum)
              if(priceSum){clearTimeout(timeout);
              // Your submit handling logic here
              
              console.log("In submitForm() : "+priceSum);
              alert(`주문이 완료되었습니다.\n주문금액 : ${"${priceSum}"}원`);}
        
            	
            try {
            	
              const data = await sendOrderData(order_list);
              console.log("In handleFormSubmission 서버 응답:", data);
              form.reset();
              const showValue = document.querySelectorAll(".value-display");
              showValue.forEach(value=>{
            	  value.textContent = "";
              })
            
            } catch (error) {
              console.error("In handleFormSubmission 오류 발생:", error);
            }
       /*    }); */
        }
        
        
       

       
       
        function handleCheckboxInactivity(durationInMilliseconds, value) {
        	console.log("▶ 5. handleCheckboxInactivity : set time");
        
        	
        	console.log("In handleCheckboxInactivity boolean arg : "+value);
        	  if (!value) {
        		  console.log("In handleCheckboxInactivity : "+checkboxInactivityActive);
        		    return; // If it's not active, don't execute the function
        		  }
        	  
        	  
            


        	  const checkboxes = document.querySelectorAll('input[type="checkbox"]');
        

        	  checkboxes.forEach(function (checkbox) {
        	    checkbox.addEventListener("change", function () {
        	      clearTimeout(timeout);
        	      console.log("In handleCheckboxInactivity : Time goes by"+timeout);
        	      timeout = setTimeout(function () {
        	        checkboxes.forEach(function (checkbox) {
        	          checkbox.checked = false;
        	        });

        	        const showValues = document.querySelectorAll(".value-display");
        	        showValues.forEach(function (showValue) {
        	          showValue.textContent = "";
        	        });

        	        alert("주문이 취소되었습니다.\n 1분안에 선택하고 주문하셔야합니다.");
        	      }, durationInMilliseconds);
        	    });
        	  });
        	}
     

        	
      </script>
</html>
