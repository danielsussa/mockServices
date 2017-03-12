package com.example;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.util.Map;


public class DemoApplicationTests {

	@Test
	public void contextLoads() throws JAXBException{

//		String xml = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\" xmlns:bjbs=\"http://schemas.datacontract.org/2004/07/BJBS.INFRA.Contracts\" xmlns:bjbs1=\"http://schemas.datacontract.org/2004/07/BJBS.CONTRACT.INFRA.Requests\"><soapenv:Header/><soapenv:Body><tem:AlterarPerfilUsuario><!--Optional:--><tem:perfilRequestCreate><!--Optional:--><bjbs:Page>?</bjbs:Page><!--Optional:--><bjbs:Rows>?</bjbs:Rows><!--Optional:--><bjbs:Sidx>?</bjbs:Sidx><!--Optional:--><bjbs:Sord>?</bjbs:Sord><bjbs:Token>?</bjbs:Token><bjbs1:Acessos><!--Zero or more repetitions:--><bjbs1:AcessoRequestUpdate><!--Optional:--><bjbs:Page>?</bjbs:Page><!--Optional:--><bjbs:Rows>?</bjbs:Rows><!--Optional:--><bjbs:Sidx>?</bjbs:Sidx><!--Optional:--><bjbs:Sord>?</bjbs:Sord><bjbs:Token>?</bjbs:Token><!--Optional:--><bjbs1:ExibirMenu>?</bjbs1:ExibirMenu><!--Optional:--><bjbs1:IdentificacaoAcesso>?</bjbs1:IdentificacaoAcesso><!--Optional:--><bjbs1:NomeAcesso>?</bjbs1:NomeAcesso><!--Optional:--><bjbs1:Pai/><!--Optional:--><bjbs1:Path>?</bjbs1:Path><bjbs1:TipoAcao>?</bjbs1:TipoAcao><bjbs1:TipoAcesso>?</bjbs1:TipoAcesso></bjbs1:AcessoRequestUpdate></bjbs1:Acessos><!--Optional:--><bjbs1:DescricaoPerfil>?</bjbs1:DescricaoPerfil><bjbs1:IdentificacaoPerfil>?</bjbs1:IdentificacaoPerfil></tem:perfilRequestCreate></tem:AlterarPerfilUsuario></soapenv:Body></soapenv:Envelope>";
//		xml = "<daniel><amigo>ola</amigo></daniel>";
//		JAXBContext context = JAXBContext.newInstance("br.com.caelum");
//		Unmarshaller unmarshaller = context.createUnmarshaller();
//		JAXBElement<Carro> element = (JAXBElement<Carro>) unmarshaller.unmarshal(new String("resources/carro.xml"));
	}

}
