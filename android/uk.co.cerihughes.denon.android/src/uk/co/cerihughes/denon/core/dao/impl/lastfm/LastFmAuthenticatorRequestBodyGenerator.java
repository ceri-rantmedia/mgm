package uk.co.cerihughes.denon.core.dao.impl.lastfm;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Comparator;
import java.util.TreeMap;

import uk.co.cerihughes.denon.core.dao.rest.RequestBodyGenerator;
import uk.co.cerihughes.denon.core.dao.rest.RequestBodyGeneratorException;

public class LastFmAuthenticatorRequestBodyGenerator implements RequestBodyGenerator
{
	private final String secret;
	private final TreeMap<String, String> treeMap = new TreeMap<String, String>(new StringComparator());

	public LastFmAuthenticatorRequestBodyGenerator(String secret)
	{
		super();
		this.secret = secret;
	}

	public String put(String key, String value)
	{
		return treeMap.put(key, value);
	}

	@Override
	public String generateRequestBody() throws RequestBodyGeneratorException
	{
		final StringBuilder signature = new StringBuilder();
		final StringBuilder body = new StringBuilder();

		for (String key : treeMap.keySet())
		{
			body.append(key);
			body.append("=");
			body.append(treeMap.get(key));
			body.append("&");

			signature.append(key);
			signature.append(treeMap.get(key));
		}

		signature.append(secret);

		final String md5 = md5(signature.toString());
		body.append("api_sig=");
		body.append(md5);
		return body.toString();
	}

	protected String md5(String input) throws RequestBodyGeneratorException
	{
		try
		{
			final MessageDigest digest = MessageDigest.getInstance("MD5");
			final byte[] bytes = digest.digest(input.getBytes());
			return encodeHex(bytes);
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw new RequestBodyGeneratorException(ex);
		}
	}

	private String encodeHex(byte[] data)
	{
		final StringBuilder sb = new StringBuilder();
		for (byte b : data)
		{
			sb.append(String.format("%02x", b & 0xff));
		}
		return sb.toString();
	}

	private class StringComparator implements Comparator<String>
	{
		public int compare(String a, String b)
		{
			return a.compareTo(b);
		}
	}
}