(function (_$$) {

    _$$.util = {

        logInfo: function (msg, stack) {
            if (_$$.env.debug) {
                console.log(msg);
                _$$.util.logStack(stack);
            }
        },

        logError: function (msg, stack) {
            if (_$$.env.debug) {
                console.error(msg);
                _$$.util.logStack(stack);
            }
        },

        logStack: function (stack) {
            if (stack) {
                console.log(new Error("").stack);
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
        },

        deepGet: function (parent, path) {
            path = path.split('.');

            for (var k = 0, kLen = path.length; k < kLen; k++) {
                if (parent != null && parent.hasOwnProperty(path[k])) {
                    parent = parent[path[k]];
                }
                else {
                    return null;
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

        quantity: function (number, item, full_string) {
            if (number < 0) {
                return item;
            }

            return (full_string ? (number > 0 ? number : "No") + " " : "") + item + ((number <= 1) ? "" : "s");
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
        },

        constant : function(key) {
            return _$$.util.deepGet(_$$.constants, key);
        },

        registerServices : function(request) {
            _$$.util.merge(request, _$$.services);
        },

        registerComponents : function(request) {
            _$$.util.merge(request, _$$.components);
        },

        registerConstants : function(request) {
            _$$.util.merge(request, _$$.constants);
        }

    }

})(rootObject);