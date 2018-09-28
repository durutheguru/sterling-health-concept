(function(_$$) {

    _$$.util = {

        logInfo : function(msg){
            if (_$$.env.debug) {
                console.log(msg);
            }
        },

        isValidString: function (str, empty) {
            return (typeof str === "string") && ((!empty) ? (!!str && !!str.length) : true);
        },

        isValidNumber: function (num) {
            return typeof num === "number";
        },

        isValidObject: function (obj) {
            return obj != null && typeof obj === "object";
        },

        isValidArray: function (arr, empty) {
            return $.isArray(arr) && ((!empty) ? arr && !!arr.length : true);
        },

        isValidFunction: function (f) {
            return typeof f == "function";
        },

        isUndefined: function (obj) {
            return typeof obj === "undefined";
        },

        managedString: function (str, maxlength) {
            if (typeof str != "string") {
                return str;
            }

            if (str.length <= maxlength) {
                return str;
            }
            else {
                return str.substring(0, maxlength) + "...";
            }
        }

    };

})(rootObject);