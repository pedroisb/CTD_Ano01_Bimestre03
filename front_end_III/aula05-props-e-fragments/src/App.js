import './App.css';
import Banner from './components/Banner';
import Footer from './components/Footer';
import Header from './components/Header';

function App() {
  return (
    <>
      <Header />
      <main>
        <Banner>
          <img src="C:\Users\Pedro Brito\Desktop\CTD_Ano01_Bimestre03\front_end_III\aula05-props-e-fragments\src\components\img\background.jpg" />
          <button></button>
          <h1>TITULO</h1>
          <p>TEXTO</p>
        </Banner>
      </main>
      <Footer />
    </>
  );
}

export default App;
