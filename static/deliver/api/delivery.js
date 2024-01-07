//查询单个地址
function getPostions(data) {
    return $axios({
    //   'url': window.gatewayURL + `/delivery/${id}`,
        // 'url': window.gatewayURL + `/delivery/postions`,
        'url': window.gatewayURL + `/delivery/postions?id=`+data,
        'method': 'get',
    })
  }
