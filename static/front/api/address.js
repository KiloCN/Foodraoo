//获取所有地址
function addressListApi() {
    return $axios({
      'url': window.gatewayURL + '/addressBook/list',
      'method': 'get',
    })
  }

//获取最新地址
function addressLastUpdateApi() {
    return $axios({
      'url': window.gatewayURL + '/addressBook/lastUpdate',
      'method': 'get',
    })
}

//新增地址
function  addAddressApi(data){
    return $axios({
        'url': window.gatewayURL + '/addressBook',
        'method': 'post',
        data
      })
}

//修改地址
function  updateAddressApi(data){
    return $axios({
        'url': window.gatewayURL + '/addressBook',
        'method': 'put',
        data
      })
}

//删除地址
function deleteAddressApi(params) {
    return $axios({
        'url': window.gatewayURL + '/addressBook',
        'method': 'delete',
        params
    })
}

//查询单个地址
function addressFindOneApi(id) {
  return $axios({
    'url': window.gatewayURL + `/addressBook/${id}`,
    'method': 'get',
  })
}

//设置默认地址
function  setDefaultAddressApi(data){
  return $axios({
      'url': window.gatewayURL + '/addressBook/default',
      'method': 'put',
      data
    })
}

//获取默认地址
function getDefaultAddressApi() {
  return $axios({
    'url': window.gatewayURL + `/addressBook/default`,
    'method': 'get',
  })
}