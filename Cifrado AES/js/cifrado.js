//nuestras variables
function cifradito(){
    let cadena = document.getElementById("contenido-archivo").value;
    const clave = document.getElementById("demo1").value;
    
    //la clave forzosamente necesita 16 , 24, 32 Padding PKCS5
    
    //proceso
    
    var cifrado = CryptoJS.AES.encrypt(cadena, clave);
    
    var descifrado = CryptoJS.AES.decrypt(cifrado, clave);
    
    document.getElementById("demo32").innerHTML = cadena;
    
    document.getElementById("saldjp").innerHTML = cifrado;
    
    document.getElementById("caso").innerHTML = descifrado;
    
    document.getElementById("demo32").innerHTML = descifrado.toString(CryptoJS.enc.Utf8);
    
    }
    function leerArchivo(e) {
        var archivo = e.target.files[0];
        if (!archivo) {
          return;
        }
        var lector = new FileReader();
        lector.onload = function(e) {
          var contenido = e.target.result;
          mostrarContenido(contenido);
        };
        lector.readAsText(archivo);
      }
      
      function mostrarContenido(contenido) {
        var elemento = document.getElementById('contenido-archivo');
        elemento.innerHTML = contenido;
      }
      
      document.getElementById('file-input')
        .addEventListener('change', leerArchivo, false);
    function validar(){
        var cadena = document.getElementById("contenido-archivo").value;
        var clave = document.getElementById("demo1").value;
        if (cadena == "" || clave =="") {
            alert("Campos vacios");
        }else if(clave.length < 16 || clave.length > 256){
            alert("la clave debe ser mayor de 16 y menor 256 caracteres");
        }else{
        cifradito();
        leerArchivo();
        descargar();
        }
    }
    function dfv(){
      let hj = document.getElementById("contenido-archivo").value;
      const nmbh = document.getElementById("demo1").value;
      var descifrado = CryptoJS.AES.decrypt(hj, nmbh);
      if(hj =="" || nmbh ==""){
        alert("En donde estan mis archivitos *W*")
      }else{
      document.getElementById("caso").innerHTML = descifrado;
      document.getElementById("saldjp").innerHTML = descifrado.toString(CryptoJS.enc.Utf8);
      }
      }
    