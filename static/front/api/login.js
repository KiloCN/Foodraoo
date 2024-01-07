let countdownSeconds = 60;
function loginApi(data) {
    return $axios({
      'url': window.gatewayURL + '/user/login',
      'method': 'post',
      data
    })
}

function sendMsgApi(data) {
    return $axios({
        'url': window.gatewayURL + '/user/sendMsg',
        'method': 'post',
        data
    })
}

function loginoutApi() {
  return $axios({
    'url': window.gatewayURL + '/user/logout',
    'method': 'post',
  })
}