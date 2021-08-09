$(document).ready(function() {
	
	// 회원가입
	$(".btn_type1").on("click", function() {
		if ($("#name").val() == "") {
			alert("성명을 입력해주세요.");
			$("#name").focus();
			return false;
		}
		if ($("#id").val() == "") {
			alert("아이디를 입력해주세요.");
			$("#id").focus();
			return false;
		}
		if ($("#pw").val() == "") {
			alert("비밀번호를 입력해주세요.");
			$("#pw").focus();
			return false;
		}
		if ($("#pwCheck").val() == "") {
			alert("비밀번호를 입력해주세요.");
			$("#pwCheck").focus();
			return false;
		}
		if ($("#pwCheck").val() != $("#pw").val()) {
			alert("비밀번호를 확인해주세요.");
			$("#pwCheck").focus();
			return false;
		}
		if ($("#email").val() == "") {
			alert("이메일을 입력해주세요.");
			$("#email").focus();
			return false;
		}
		if ($("#company").val() == "") {
			alert("회사명을 입력해주세요.");
			$("#company").focus();
			return false;
		}
		if ($("#department").val() == "") {
			alert("부서명을 입력해주세요.");
			$("#department").focus();
			return false;
		}	
		if ($("#position").val() == "") {
			alert("직급을 입력해주세요.");
			$("#position").focus();
			return false;
		}
		
		var idChkVal = $("#idChk").val();
		var cpChkVal = $("#cpCodeChk").val();
		var dmChkVal = $("#dmCodeChk").val();
		if (idChkVal == "N") {
			alert("중복확인 버튼을 눌러주세요.");
			return false;
		} else if (cpChkVal == "N"){
			alert("회사코드를 인증해주세요.");
			return false;
		} else if (dmChkVal == "N"){
			alert("부서코드를 인증해주세요.");
			return false;
		} else if (idChkVal == "Y" && dmChkVal == "Y" && dmChkVal == "Y") {
			$("#regForm").submit();
		}
		
	});
	
	// 취소
	$(".btn_type2").on("click", function() {
		location.href = "/";
	})
	
	// 중복확인
	$("#idChk").on("click", function() {
		fn_idChk();
	})
	
	// 회사코드
	$("#cpCodeChk").on("click", function() {
		fn_cpCodeChk();
	})
	
	// 부서코드
	$("#dmCodeChk").on("click", function() {
		fn_dmCodeChk();
	})

	
	function fn_idChk() {
		$.ajax({
			url : "IdCheck",
			type : "post",
			dataType : "json",
			data : {
				"id" : $("#id").val()
			},
			success : function(data) {
				if (data == 1) {
					alert("중복된 아이디입니다.");
				} else if (data == 0) {
					$("#idChk").attr("value", "Y");
					alert("사용가능한 아이디입니다.");
				}
			}
		})
	}
	
	function fn_cpCodeChk() {
		$.ajax({
			url : "cpCodeCheck",
			type : "post",
			dataType : "json",
			data : {
				"cpCode" : $("#cpCode").val()
			},
			success : function(data) {
				if (data == 1) {
					$("#cpCodeChk").attr("value", "Y");
					alert("인증되었습니다.");
				} else if (data == 0) {
					alert("존재하지 않는 회사코드입니다.");
				}
			}
		})
	}
	
	function fn_dmCodeChk() {
		$.ajax({
			url : "dmCodeCheck",
			type : "post",
			dataType : "json",
			data : {
				"dmCode" : $("#dmCode").val()
			},
			success : function(data) {
				if (data == 1) {
					$("#dmCodeChk").attr("value", "Y");
					alert("인증되었습니다.");
				} else if (data == 0) {
					alert("존재하지 않는 부서코드입니다.");
				}
			}
		})
	}
	
	
});


