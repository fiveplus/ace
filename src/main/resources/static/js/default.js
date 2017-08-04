/**
 * @author zhangshenwu
 * @version 1.0.0
 * 简单工具构建
 */
//Map工具构建
var Map = function(key,value){
	this._entrys = new Array();
	this.put = function(key,value){
		if(key == null || key == undefined){
			return;
		}
		var index = this._getIndex(key);
		if(index == -1){
			var entry = new Object();
			entry.key = key;
			entry.value = value;
			this._entrys[this._entrys.length] = entry;
		}else{
			this._entrys[index].value = value;
		}
	};
	this.get = function(key){
		var index = this._getIndex(key);
		return (index!=-1)?this._entrys[index].value:null;
	};
	this.remove = function(key){
		var index = this._getIndex(key);
		if(index != -1){
			this._entrys.splice(index, 1);
		}
	};
	
	
	this.clear = function(){
		this._entrys.length = 0;
	};
	this.contains = function(key){
		var index = this._getIndex(key);
		return (index!=-1)?true:false;
	};
	this.getCount = function(){
		return this._entrys.length;
	};
	this.getEntrys = function(){
		return this._entrys;
	};
	this._getIndex = function(key){
		if(key == null || key == undefined){
			return -1;
		}
		var _length = this._entrys.length;
		for(var i = 0;i<_length;i++){
			var entry = this._entrys[i];
			if(entry == null || entry == undefined){
				continue;
			}
			if(entry.key == key){
				return i;
			}
		}
		return -1;
	};
	
};

/**
 * @fileoverview 百度地图浏览区域限制类，对外开放。
 * 允许开发者输入限定浏览的地图区域的Bounds值，
 * 则地图浏览者只能在限定区域内浏览地图。
 * 基于Baidu Map API 1.2。
 *
 * @author Baidu Map Api Group 
 * @version 1.2
 */
  
  /** 
   * @namespace BMap的所有library类均放在BMapLib命名空间下
   */
  var BMapLib = window.BMapLib = BMapLib || {};
  
  (function() {
  
      /** 
       * @exports AreaRestriction as BMapLib.AreaRestriction 
       */
      var AreaRestriction =
          /**
           * AreaRestriction类，静态类，不用实例化
           * @class AreaRestriction类提供的都是静态方法，勿需实例化即可使用。     
           */
          BMapLib.AreaRestriction = function(){
          }
      
      /**
       * 是否已经对区域进行过限定的标识
       * @private
       * @type {Boolean}
       */
      var _isRestricted = false;
  
      /**
       * map对象
       * @private
       * @type {BMap}
       */
      var _map = null;
  
      /**
       * 开发者需要限定的区域
       * @private
       * @type {BMap.Bounds}
       */
      var _bounds = null;
  
      /**
       * 对可浏览地图区域的限定方法
       * @param {BMap} map map对象
       * @param {BMap.Bounds} bounds 开发者需要限定的区域
       *
       * @return {Boolean} 完成了对区域的限制即返回true，否则为false
       */
      AreaRestriction.setBounds = function(map, bounds){
          // 验证输入值的合法性
          if (!map || 
              !bounds || 
              !(bounds instanceof BMap.Bounds)) {
                  throw "请检查传入参数值的合法性";
                  return false;
          }
          
          if (_isRestricted) {
              this.clearBounds();
          }
          _map = map;
          _bounds = bounds;
  
          // 添加地图的moving事件，用以对浏览区域的限制
          _map.addEventListener("moveend", this._mapMoveendEvent);
          _isRestricted = true;
          return true;
      };
  
      /**
       * 需要绑定在地图移动事件中的操作，主要控制出界时的地图重新定位
       * @param {Event} e e对象
       *
       * @return 无返回值
       */
      AreaRestriction._mapMoveendEvent = function(e) {
          // 如果当前完全没有出界，则无操作
          if (_bounds.containsBounds(_map.getBounds())) {
              return;
          }
  
          // 两个需要对比的bound区域的边界值
          var curBounds = _map.getBounds(),
                curBoundsSW = curBounds.getSouthWest(),
                curBoundsNE = curBounds.getNorthEast(),
                _boundsSW = _bounds.getSouthWest(),
                _boundsNE = _bounds.getNorthEast();
  
          // 需要计算定位中心点的四个边界
          var boundary = {n : 0, e : 0, s : 0, w : 0};
          
         // 计算需要定位的中心点的上方边界
         boundary.n = (curBoundsNE.lat < _boundsNE.lat) ? 
                                     curBoundsNE.lat :
                                     _boundsNE.lat;
 
         // 计算需要定位的中心点的右边边界
         boundary.e = (curBoundsNE.lng < _boundsNE.lng) ? 
                                     curBoundsNE.lng :
                                     _boundsNE.lng;
 
         // 计算需要定位的中心点的下方边界
         boundary.s = (curBoundsSW.lat < _boundsSW.lat) ? 
                                     _boundsSW.lat :
                                     curBoundsSW.lat;
 
         // 计算需要定位的中心点的左边边界
         boundary.w = (curBoundsSW.lng < _boundsSW.lng) ? 
                                     _boundsSW.lng :
                                     curBoundsSW.lng;
         
         // 设置新的中心点
        var center = new BMap.Point(boundary.w + (boundary.e - boundary.w) / 2,
                                                          boundary.s + (boundary.n - boundary.s) / 2);
        setTimeout(function() {
             _map.panTo(center, {noAnimation : "no"});
         }, 1);
     };
 
     /**
      * 清除对地图浏览区域限定的状态
      * @return 无返回值
      */
     AreaRestriction.clearBounds = function(){
         if (!_isRestricted) {
             return;
         }
         _map.removeEventListener("moveend", this._mapMoveendEvent);
         _isRestricted = false;
     };
 
 })();
