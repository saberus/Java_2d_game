package com.saber.gameOne.tiles;

import com.saber.gameOne.graphics.Assets;

public class RockTile extends Tile {

	public RockTile(int id) {
		super(Assets.stone1	, id);
		
	}
	
	@Override
	public boolean isSolid() {
		return true;
	}

	

}
