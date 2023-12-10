const signInBtn = document.getElementById("signIn");
const signUpBtn = document.getElementById("signUp");
// const joinForm = document.getElementById("join");
// const loginForm = document.getElementById("login");
const container = document.querySelector(".container");

signInBtn.addEventListener("click", () => {
  container.classList.remove("right-panel-active");
});

signUpBtn.addEventListener("click", () => {
  container.classList.add("right-panel-active");
});

// joinForm.addEventListener("submit", (e) => e.preventDefault());
// loginForm.addEventListener("submit", (e) => e.preventDefault());

function registerMember(form) {
	
	var result = (
		isValid(form.custid, "아이디" , null, null)
		&& isValid(form.pwd, "비밀번호", null, null)
		&& isValid(form.custname, "이름", null, null)
		&& isValid(form.phone, "전화번호", null, null)
		&& isValid(form.addr, "주소", null, null)
	);
	
	if (result == false) {
		return false;
	}
	container.classList.remove("right-panel-active");
}

function isValid(field, fieldName, focusField) {

	if (isEmpty(field.value) == true) {
		/* 종성으로 조사(을 또는 를) 구분 */
		var message = (fieldName + "을 확인해 주세요."); 
		field.focus();
		alert(message);
		return false;
	}

	return true;
}

function isEmpty(value) {
	if (value == null || value == "" || value == undefined || (value != null && typeof value == "object" && !Object.keys(value).length)) {
		return true;
	}

	return false;
}