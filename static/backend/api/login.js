function loginApi(data) {
  return $axios({
    'url': window.gatewayURL +'/employee/login',
    'method': 'post',
    data
  })
}

function logoutApi(){
  return $axios({
    'url': window.gatewayURL +'/employee/logout',
    'method': 'post',
  })
}
