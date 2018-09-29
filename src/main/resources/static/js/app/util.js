(function (_$$) {

    _$$.util = {

        logInfo: function (msg) {
            if (_$$.env.debug) {
                console.log(msg);
                _$$.util.logStack();
            }
        },

        logError: function (msg) {
            if (_$$.env.debug) {
                console.error(msg);
                _$$.util.logStack();
            }
        },

        logStack: function () {
            var e = new Error("Stack");
            console.log(e.stack);
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
        },

        deepGet: function (parent, path) {
            path = path.split('.');

            for (var k = 0, kLen = path.length; k < kLen; k++) {

                if (parent.hasOwnProperty(path[k])) {
                    parent = parent[path[k]];

                } else {
                    return; // undefined? null? error?
                }
            }
            return parent;
        },

        errorSanitize: function (msg) {
            if (msg.indexOf("java.") > -1) {
                return "Unknown Error";
            }

            return msg;
        },

        extractError: function (errorResponse) {
            var errorMsg = _$$.util.deepGet(errorResponse, "response.data.message");
            return _$$.util.isValidString(errorMsg) ? _$$.util.errorSanitize(errorMsg) : "Unknown Error";
        },

        merge: function (src, dest) {
            if (typeof src != "object") {
                throw new Error("Source must be Javascript objects");
            }

            if (typeof dest != "object") {
                dest = {};
            }

            for (var i in src) {
                dest[i] = src[i];
            }

            return dest;
        }
    }

})(rootObject);