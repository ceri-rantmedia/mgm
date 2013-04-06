package uk.co.cerihughes.denon.core.dao.impl;

import java.util.Collection;

import org.teleal.cling.UpnpService;
import org.teleal.cling.UpnpServiceImpl;
import org.teleal.cling.registry.RegistryListener;

import uk.co.cerihughes.denon.core.dao.DaoException;
import uk.co.cerihughes.denon.core.dao.EDaoType;
import uk.co.cerihughes.denon.core.dao.IDao;
import uk.co.cerihughes.denon.core.dao.IDaoFactoryListener;
import uk.co.cerihughes.denon.core.dao.impl.dlna.DlnaServiceDao;
import uk.co.cerihughes.denon.core.dao.impl.lastfm.LastFmServiceDao;
import uk.co.cerihughes.denon.core.dao.impl.spotify.SpotifyServiceDao;
import uk.co.cerihughes.denon.core.model.Artist;

public class NonAndroidDaoFactory extends DaoFactory
{
	@Override
	protected UpnpService createUpnpService(RegistryListener listener)
	{
		return new UpnpServiceImpl(listener);
	}

	public static void main(String[] args) throws Exception
	{
		final NonAndroidDaoFactory factory = new NonAndroidDaoFactory();
		factory.addListener(new IDaoFactoryListener()
		{

			@Override
			public void daoRemoved(IDao dao)
			{
				System.out.println(String.format("Dao removed [%s]", dao));
			}

			@Override
			public void daoAdded(IDao dao)
			{
				try
				{
					if (dao.getType() == EDaoType.DLNA_DIRECT)
					{
						final DlnaServiceDao dlna = (DlnaServiceDao) dao;
						Collection<Artist> artists = dlna.allArtists();
						System.out.println(String.format("All DLNA Artists (%d) : %s", artists.size(), artists.toString()));

					}
					else if (dao.getType() == EDaoType.SPOTIFY_DIRECT)
					{
						final SpotifyServiceDao spotify = (SpotifyServiceDao) dao;
						Collection<Artist> artists = spotify.searchArtists("Ian");
						System.out.println(String.format("All Spotify 'Ian' Artists (%d) : %s", artists.size(), artists.toString()));

					}
					if (dao.getType() == EDaoType.LAST_FM_DIRECT)
					{
						final LastFmServiceDao lastFm = (LastFmServiceDao) dao;
						Collection<Artist> artists = lastFm.getFavouriteArtists();
						System.out.println(String.format("All Last FM Favourite Artists (%d) : %s", artists.size(), artists.toString()));
					}
				}
				catch (DaoException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				System.out.println(String.format("Dao added [%s]", dao));
			}
		});
		factory.start();
	}
}
