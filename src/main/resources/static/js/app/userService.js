let main = {
    init : function () {
        let _this = this;

        // $('아이디').
        $('#btn-save').on('click', function () {
            _this.signIn();
        });

        $('#btn-login').on('click', function () {
            _this.login();
        });

        $('#btn-update').on('click', function () {
            _this.userInfoUpdate();
        });

        $('#btn-delete').on('click', function () {
            _this.userDelete();
        });
    },
    signIn : function () {
        let data = {
            name: $('#name').val(),
            email: $('#email').val(),
            pwd: $('#pwd').val(),
            phone: $('#phone').val(),
            address: $('#address').val(),
            role : $('#role').val(),

        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/user',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('가입이 완료되었습니다.');
            window.location.href = '/';
        //    가입  완료 후 메인 이동
        }).fail(function (error) {
            alert(JSON.stringify(error));
        //    가입 실패 경고창
        });
    },
    login : function () {
        let data = {
            email: $('#email').val(),
            pwd: $('#pwd').val(),
            save_email_checked: $('#save_email:checked').val(),
        }
         console.log('로그인 데이터 js')
        // 이메일 저장 체크시 불러오기
        if(data.save_email_checked == 'on'){
            localStorage.setItem("saveEmail", data.email);
        }else{
            localStorage.setItem("saveEmail", 'N');
        }
    console.log(data);

        $.ajax({
            type: 'POST',
            url: '/api/v1/user/'+data.email,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data),
        }).done(function() {
            alert(data.email+'님 환영합니다!');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    userInfoUpdate : function () {
        let data = {
            pwd: $('#pwd').val(),
            phone: $('#phone').val(),
            address: $('#address').val(),

        };

        let id = $('#id').val();

        $.ajax({
            type: 'PUT',
            url: '/api/v1/user/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert(' 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    userDelete : function () {
        let id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/user/'+id,
            dataType: 'json',
            contentType:'application/json; charset=utf-8'
        }).done(function() {
            alert('탈퇴되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();