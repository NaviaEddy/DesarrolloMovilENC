import 'package:flutter/material.dart';
import 'calculadora.dart';

void main() {
  runApp(const Principal());
}
/* PRIMER EJERCICIO */
// class Principal extends StatelessWidget{
//   const Principal({super.key});

//   @override
//   Widget build(BuildContext context){
//     return MaterialApp(
//       home: Scaffold(
//         appBar: AppBar(
//           title: const Text('Saludo')
//         ),
//         body: const Center(
//           child: MiClaseEstatica(),
//         ),
//       ),
//     );
//   }
// }

// class MiClaseEstatica extends StatelessWidget{
//   const MiClaseEstatica({super.key});

//   @override
//   Widget build(BuildContext context){
//     return const Text('Hola Mundo', style: TextStyle(fontSize: 24, color: Colors.blue),);
//   }
// }

/* SEGUNDO EJERCICIO */
// class Principal extends StatelessWidget{
//   const Principal({super.key});

//   @override
//   Widget build(BuildContext context){
//     return MaterialApp(
//       home: Scaffold(
//         appBar: AppBar(
//           title: const Text('Contador'),
//         ),
//         body: const Center(
//           child: ContenidoDinamico(),
//         ),
//       ),
//     );
//   }
// }

// class ContenidoDinamico extends StatefulWidget{
//   const ContenidoDinamico({super.key});

//   @override
//   _ContenidoDinamicoState createState() => _ContenidoDinamicoState();

// }

// class _ContenidoDinamicoState extends State<ContenidoDinamico>{
//   int _cont = 0;
//   void _incrementarContador(){
//     setState(() {
//       _cont++;
//     });
//   }

//   @override
//   Widget build(BuildContext context){
//     return Column(
//       mainAxisAlignment: MainAxisAlignment.center,
//       children: <Widget>[
//         const Text('Has presionado el botón tantas veces:', style: TextStyle(fontFamily: 'RobotoMono', fontSize: 24, color: Colors.blue),),
//         Text('$_cont', style: const TextStyle(fontSize: 30, color: Colors.cyan),),
//         ElevatedButton(
//           style: ButtonStyle(
//             backgroundColor: MaterialStateProperty.all<Color>(Colors.blue),
//             foregroundColor: MaterialStateProperty.all<Color>(Colors.white),
//           ),
//           onPressed: _incrementarContador,
//           child: const Text('Presioname'),
//         )
//       ],
//     );
//   }
// }

/* TERCER EJERCICIO */
class Principal extends StatelessWidget {
  const Principal({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: Operaciones(),
    );
  }
}

class Operaciones extends StatefulWidget {
  const Operaciones({super.key});

  @override
  // ignore: library_private_types_in_public_api
  _OperacionesState createState() => _OperacionesState();
}

class _OperacionesState extends State<Operaciones> {
  // ignore: non_constant_identifier_names
  final TextEditingController _Caja1 = TextEditingController();
  // ignore: non_constant_identifier_names
  final TextEditingController _Caja2 = TextEditingController();
  int _resultado = 0;

  void _sumar() {
    setState(() {
      final int num1 = int.tryParse(_Caja1.text) ?? 0;
      final int num2 = int.tryParse(_Caja2.text) ?? 0;
      _resultado = Calculadora().suma(num1, num2);
    });
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text('Suma de numeros'),
      ),
      body: Padding(
        padding: const EdgeInsets.all(20.0),
        child: Column(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          TextField(
            controller: _Caja1,
            keyboardType: TextInputType.number,
            decoration: const InputDecoration(
              hintText: 'Número 1',
              hintStyle: TextStyle(
                color: Colors.grey, // Cambia el color del hintText
              ),
              border:
                  OutlineInputBorder(), // Borde simple alrededor del campo de texto
              contentPadding: EdgeInsets.symmetric(
                vertical: 10.0,
                horizontal: 15.0,
              ), // Padding interno del campo de texto
            ),
          ),
          TextField(
            controller: _Caja2,
            keyboardType: TextInputType.number,
            decoration: const InputDecoration(
              hintText: 'Número 2',
              hintStyle: TextStyle(
                color: Colors.grey, // Cambia el color del hintText
              ),
              border:
                  OutlineInputBorder(), // Borde simple alrededor del campo de texto
              contentPadding: EdgeInsets.symmetric(
                vertical: 10.0,
                horizontal: 15.0,
              ), // Padding interno del campo de texto
            ),
          ),
          ElevatedButton(
            style: ButtonStyle(
              backgroundColor: MaterialStateProperty.all<Color>(Colors.blue),
              foregroundColor: MaterialStateProperty.all<Color>(Colors.white),
            ),
            onPressed: _sumar,
            child: const Text('Sumar'),
          ),
          Text(
            'Resultado: $_resultado',
            style: const TextStyle(fontSize: 30, color: Colors.green),
          ),
        ],
      ),
    )
    );
  }
}
